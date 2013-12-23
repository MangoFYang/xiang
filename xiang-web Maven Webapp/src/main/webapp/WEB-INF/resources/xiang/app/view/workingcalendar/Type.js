
Ext.define('Xiang.view.workingcalendar.Type', {
	extend: 'Ext.tab.Panel',
		
	bodyCls: 'x-border-layout-ct',
	tabPosition: 'bottom',
	
	/*
	initData: function() {
		Ext.Ajax.request({
		    url: contextPath + '/demo/WorkingCalendarMaintainController/paramType',
		    success: function(response, opts) {
		        var obj = Ext.decode(response.responseText);
		        console.dir(obj);
		    },
		    failure: function(response, opts) {
		        console.log('server-side failure with status code ' + response.status);
		    }
		});
	},
	*/
	
	initComponent: function() {
		
		var calendarTypeGridStore = Ext.create('Xiang.store.MyGridStore', {
			fields:['id', 'typeName'],
			proxy: {
				url: '/demo/WorkingCalendarMaintainController/listWorkingCalendarType'
			}
		});
		
		var calendarDefinitionGridStore = Ext.create('Xiang.store.MyGridStore', {
			autoLoad: false,
			fields:['id', 'paramType_label', 'param_label'],
			proxy: {
				url: '/demo/WorkingCalendarMaintainController/listWorkingCalendarDefinition'
			},
			listeners: {
				beforeload: function( store, operation, eOpts ) {
					return !!this.proxy.extraParams['workingCalendarType.id'];
				}
			}
		});
		
		var typeStore = Ext.create('Xiang.store.MyGridStore', {
			fields:['type', 'label'],
			proxy: {
				url: '/demo/WorkingCalendarMaintainController/listParamType'
			}
		});

		var paramStore = Ext.create('Xiang.store.MyGridStore', {
			autoLoad: false,
	    	fields:['id', 'code', 'label'],
	        proxy: {
	            url : '/demo/WorkingCalendarMaintainController/listParam'
	        },
	        listeners: {
				beforeload: function( store, operation, eOpts ) {
					return !!this.proxy.extraParams['paramType.type'];
				}
			}
	    });
		
		Ext.apply(this, {
			items: [{
				title: '类型',
				xtype: 'container',
				layout:'vbox',
				items: [{
					itemId: 'calendarTypeGrid',
					flex: 3,
					xtype: 'gridpanel',
					// title: '参数类型列表',
					title: false,
					width: '100%',
					height: '100%',
				    store: calendarTypeGridStore,
				    forceFit: true,
				    columns: [
				        { text: '序号', xtype: 'rownumberer', minWidth: 36, maxWidth: 36, align: 'center'},
				        { text: '标识', dataIndex: 'id', hidden: true },
				        { text: '名称', dataIndex: 'typeName' }
				    ],
				    listeners: {
				    	select: function( self, record, index, eOpts ) {
				    		var paramGrid = this.ownerCt.getComponent('calendarDefinitionGrid');
				    		var ps = paramGrid.getStore();
				    		ps.getProxy().setExtraParam( "workingCalendarType.id", record.get("id") );
				    		ps.loadPage(1);
				    	}
				    },
				    rbar: [{
						xtype: 'button',
						text: '添加',
						handler: function(button, e) {
							Ext.create('Xiang.view.workingcalendar.TypeAdd').show();
						}
					}],
				    bbar: {
		                xtype: 'pagingtoolbar',
		                store: calendarTypeGridStore,
		                displayInfo: true
		            }
				}, { 
					xtype: 'splitter'
				}, {
					itemId: 'calendarDefinitionGrid',
					flex: 3,
					xtype: 'gridpanel',
					title: '工作日历定义',
					width: '100%',
					height: '100%',
				    store: calendarDefinitionGridStore,
				    forceFit: true,
				    columns: [
		              	{ text: '序号', xtype: 'rownumberer', minWidth: 36, maxWidth: 36, align: 'center'},
				        { text: '标识',  dataIndex: 'id', hidden: true },
				        { text: '工作日历参数类型', dataIndex: 'paramType_label'},
				        { text: '工作日历参数', dataIndex: 'param_label'}
				    ],
				    bbar: {
		                xtype: 'pagingtoolbar',
		                store: calendarDefinitionGridStore,
		                // disabledRefreshBtn: true,
		                displayInfo: true
		            },
				}]
				
			}, {
				title: '参数类型',
				xtype: 'container',
				layout:'hbox',
				items: [{
					itemId: 'typeGrid',
					flex: 2,
					xtype: 'gridpanel',
					title: '参数类型列表',
					width: '100%',
					height: '100%',
				    store: typeStore,
				    forceFit: true,
				    columns: [
				        { text: '序号', xtype: 'rownumberer', minWidth: 36, maxWidth: 36, align: 'center'},
				        { text: '类型',  dataIndex: 'type' },
				        { text: '名称', dataIndex: 'label' }
				    ],
				    listeners: {
				    	select: function( self, record, index, eOpts ) {
				    		var paramGrid = this.ownerCt.getComponent('paramGrid');
				    		var ps = paramGrid.getStore( );
				    		ps.getProxy().setExtraParam( "paramType.type", record.get("type") );
				    		ps.loadPage(1);
				    	}
				    },
				    bbar: {
		                xtype: 'pagingtoolbar',
		                store: typeStore,
		                displayInfo: true
		            }
				}, { 
					xtype: 'splitter'
				}, {
					itemId: 'paramGrid',
					flex: 3,
					xtype: 'gridpanel',
					title: '参数列表',
					width: '100%',
					height: '100%',
				    store: paramStore,
				    forceFit: true,
				    columns: [
		              	{ text: '序号', xtype: 'rownumberer', minWidth: 36, maxWidth: 36, align: 'center'},
				        { text: '标识',  dataIndex: 'id', hidden: true },
				        { text: '代码', dataIndex: 'code'},
				        { text: '名称', dataIndex: 'label' }
				    ],
				    bbar: {
		                xtype: 'pagingtoolbar',
		                store: paramStore,
		                displayInfo: true
		            }
				}]
			}]
		});
		
        this.callParent(arguments);
    }
	
});