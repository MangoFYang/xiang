/*
 * Smile UI olist 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *	smile.ui.obaselist.js
 */
(function($, undefined) {
/*
<div class="o-border-box ui-widget ui-widget-content ui-corner-all" style="width: 300px;">
	<div class="o-oinput4list-search">
		<input />
	</div>
	<div style="overflow: auto; height: 200px;">
		<ul id="olist">
			<li>aaaa</li>
		</ul>
	</div>
	<div class="o-list-pager">
		<div class="o-pager-item ui-corner-all" style="left: 10px;">
			<span class="ui-icon ui-icon-seek-first"></span>
		</div>
		<div class="o-pager-item ui-corner-all" style="left: 35px;">
			<span class="ui-icon ui-icon-seek-prev"></span>
		</div>
		<div class="o-pager-item ui-corner-all" style="left: 60px;">
			<span class="ui-icon ui-icon-seek-next"></span>
		</div>
		<div class="o-pager-item ui-corner-all" style="left: 85px;">
			<span class="ui-icon ui-icon-seek-end"></span>
		</div>
		<div class="o-pager-item ui-corner-all" style="right: 10px; color: #4C4C4C;">
			<span style="display: block; margin: 3px;">Displaying 1 - 10 of 29</span>
		</div>
	</div>
	<div id="olist-mask" class="ui-widget-overlay o-unselect" style="display: none;"></div>
</div>
 */
 
	// 正在查询期间
var	pending = 0,
	// 用于防止使用远程数据源时条件的竞争
	requestIndex = 0,
	// 分页信息
	pager = {
		// 当前页，从1开始。
		page: 1,
		// 每页大小。
		size: 50,
		// 总记录数。
		totalElements: 0,
		// 总页数。
		totalPages: 0,
		// 当前页记录数。
		numberOfElements: 0,
		// 是否有前页。
		hasPreviousPage: false,
		// 是否有后页。
		hasNextPage: false,
		// 是否为第一页。
		isFirstPage: true,
		// 是否为最后一页。
		isLastPage: true,
		// 数据
		content: [],
		// 分页文本
		ptext: "{0} - {1} / {2}",
		// 空数据文本
		btext: "无匹配数据",
		
		// 设置总记录数和总页数和数据
		setTotalElementsAndTotalPagesAndContent: function(content) {
			this.content = content;
			this.totalElements = content.length;
			this.totalPages = (this.totalElements === 0 ? 0 : Math.ceil(this.totalElements / this.size));
		},
		// 获取当前页数据, 继续填充完分页信息。
		getContent: function() {
			var first = (this.page - 1) * this.size,
				page = this.content.slice( first, first + this.size );
			this.numberOfElements = page.length;
			this.hasPreviousPage = ( this.page > 1 );
			this.isFirstPage = !this.hasPreviousPage;
			this.hasNextPage = this.page * this.size < this.totalElements;
			this.isLastPage = !this.hasNextPage;
			return page;
		},
		text: function() {
			if(this.content.length) {
				var first = (this.page - 1) * this.size,
					max = Math.min(first + this.size, this.totalElements);
				return Smile.util.formatString(this.ptext, first + 1, max, this.totalElements);
			} else {
				return this.btext;
			}
		},
		setPage: function(page) {
			this.page = page;
		},
		first: function() {
			this.setPage(1);
		},
		next: function() {
			if(this.hasNextPage) {
				this.setPage(this.page + 1);
			}
		},
		prev: function() {
			if(this.hasPreviousPage) {
				this.setPage(this.page - 1);
			}
		},
		end: function() {
			this.setPage(this.totalPages);
		}
	};

// 不对IE6、IE7做主流支持
$.widget("smile.opageablelist", $.smile.obaselist, {
	
	options: {
		// 每页记录数
		size: 50,
		// 有分页数据时文本
		ptext: "{0} - {1} of {2}",
		// 数据集为空时文本
		btext: "无匹配数据",
		
		// 覆盖选项
		multiSelect: false
	},
	
	_input: undefined,
	_pager: undefined,
	_pagerText: undefined,
	
	_create: function() {
		$.smile.obaselist.prototype._create.apply( this );
		var self = this,
			ele = self.element,
			opts = self.options,
			d = "<div>",
			i = "<input>",
			span = "<span>";
		
		// 设置分页信息
		pager.size = opts.size;
		pager.ptext = opts.ptext;
		pager.btext = opts.btext;

		self._body
			.css({
				height: opts.height - 64
			})
			.before(function() {
				return $(d).addClass("o-list-search")
					.append(
						self._input = $(i).on({
							keyup: function(event) {
								self._search(self._input.val(), event);
							}
						})
					);
			})
			.after(function() {
				var pager = self._pager = $(d)
					.addClass("o-list-pager")
				$.each([{
					left: "10px",
					icon: "first"
				}, {
					left: "35px",
					icon: "prev"
				}, {
					left: "60px",
					icon: "next"
				}, {
					left: "85px",
					icon: "end"
				}], function(i, n) {
					pager.append(
						$(d).addClass("o-pager-item ui-corner-all")
							.css({
								left: n.left
							})
							.attr("role", n.icon)
							.append(
								$(span).addClass("ui-icon ui-icon-seek-" + n.icon)
							)
					)
				});
				pager.append(
					$(d).addClass("o-pager-text")
					.css({
						right: "10px",
						color: "#4C4C4C"
					})
					.append(
						self._pagerText = $(span).css({
							display: "block", 
							margin: "3px"
						})
					)
				)
				return pager;
			});
	},
	
	_initEvent: function() {
		$.smile.obaselist.prototype._initEvent.apply( this );
		var self = this;
		this._pager.on({
			click: function( event ) {
				pager[$( event.currentTarget ).attr("role")]();
				self.__response( pager.getContent() );
			},
			mouseenter: function( event ) {
				$( event.currentTarget ).addClass( "o-pager-item-hover" );
			},
			mouseleave: function( event ) {
				$( event.currentTarget ).removeClass( "o-pager-item-hover" );
			}
		}, "div.o-pager-item");
	},
	
	_initData: function() {
		var url,
			self = this,
			data = this.options.data;
		if ( $.isArray(data) ) {
			this._data = function( request, response ) {
				response( self._filter( data, request.term));
			};
		} else if ( typeof this.options.data === "string" ) {
			url = this.options.data;
			this._data = function( request, response ) {
				if ( self.xhr ) {
					self.xhr.abort();
				}
				self.xhr = $.ajax({
					url: url,
					data: request,
					dataType: "json",
					success: function( data, status ) {
						response( data || [] );
					},
					error: function() {
						response( [] );
					}
				});
			};
		}
		self.search("");
	},
	
	_search: function( value, event ) {
		if ( value.length < this.options.minLength ) {
			return;
		}
		if ( this._trigger( "search", event ) === false ) {
			return;
		}
		// 重查时，重置为第一页。
		pager.first();
		// 正在查询期间
		pending ++;
		this._input.addClass( "o-list-loading" );
		this._data( { term: value }, this._response() );
	},

	_response: function() {
		var self = this,
			index = ++ requestIndex;

		return function( content ) {
			if ( index === requestIndex ) {
				// 设置总记录数和总页数和数据
				pager.setTotalElementsAndTotalPagesAndContent(content);
				// 获取当前数据并渲染
				self.__response( pager.getContent() );
			}
			pending--;
			if ( !pending ) {
				self.element.removeClass( "o-list-loading" );
			}
		};
	},
	
	__response: function( content ) {
		var self = this;
		this._trigger( "response", null, { content: content } );
		if (content && content.length) {
			self._renderMenu(self.element, $.map(content, function(n) {
				return self._normalize(n, self._input.val());
			}));
		} else {
			self._renderMenu(self.element, []);
		}
		self._pagerText.text(pager.text());
	},
	
	_escapeRegex: function( value ) {
		return value.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, "\\$&");
	},
	
	_filter: function(array, term) {
		var self = this;
		var matcher = new RegExp( self._escapeRegex(term), "i" );
		return $.grep( array, function(value) {
			return matcher.test( 
					value[self.options.displayField] || value[self.options.valueField] || value );
		});
	},
	
	/**
	 * 根据条件(term)使用户数据标准化
	 * @param item 用户数据
	 * @param term 条件
	 * @returns 标准化的数据，ocombobox可直接使用
	 */
	_normalize: function( item, term ) {
		term = term || "";
		var displayValue = item[this.options.displayField];
		var hiddenValue = item[this.options.valueField];
		if(term === "") {
			return {
				label: displayValue,
				hiddenValue: hiddenValue,
				crudeItem: item
			};
		} else {
			// 手动输入时term
			var matcher = new RegExp( this._escapeRegex(term), "i" );
			if(matcher.test(displayValue)) {
				return {
					label: displayValue.replace(
							new RegExp(
									"(?![^&;]+;)(?!<[^<>]*)(" +
									this._escapeRegex(term) +
									")(?![^<>]*>)(?![^&;]+;)", "gi"
							), '<strong style="color:#FF0000">$1</strong>' ),
					hiddenValue: hiddenValue,
					crudeItem: item
				};
			}
		}
	},
	
	search: function( value, event ) {
		this._input.val(value);
		return this._search( value, event );
	},
	
	getPager: function() {
		return pager;
	}
	
});

})(jQuery);

