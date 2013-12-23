
Ext.define('Xiang.view.workingcalendar.TypeAdd', {
	extend: 'Ext.window.Window',
	
	initComponent: function() {
		
		// 指示是否正在编辑
		var editingFlag = false;
		
		var gridstore = Ext.create('Ext.data.Store', {
	        fields:['name', 'email', 'phone'],
	        data: [
	               /*
	               {name: 'a', email: 'a'},
	               {name: 'a', email: 'a'},
	               {name: 'a', email: 'a'},
	               {name: 'a', email: 'a'},
	               {name: 'a', email: 'a'},
	               {name: 'b', email: 'b'}
	               */
	        ]
	    });
		
		var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2,
            listeners: {
            	beforeedit: function( editor, context, eOpts ) {
            		if(context.value != '') {
            			var r = paramTypeStore.findRecord('label', context.value);
            			paramByParamTypeStore.getProxy().setExtraParam( "paramType", r.raw.type );
        	    		paramByParamTypeStore.load();
            		}
            	},
            	edit: function(editor, e) {
            		editingFlag = false;
            		paramByParamTypeStore.removeAll();
            	},
            	canceledit: function(editor, context, eOpts) {
            		if(!context.value || context.value == '') {
            			gridstore.removeAt(0);
            		}
            		editingFlag = false;
            	}
            }
        });
		
		var paramTypeStore = Ext.create('Xiang.store.MyStore', {
		    proxy: {
		        url: '/demo/WorkingCalendarMaintainController/paramType',
		        reader: {
		            root: 'paramType',
		            idProperty: 'type'
		        }
		    },
		    fields: ['type', 'label']
		});
		
		var paramByParamTypeStore = Ext.create('Xiang.store.MyStore', {
			proxy: {
				url: '/demo/WorkingCalendarMaintainController/paramByParamType',
				reader: {
					root: 'param'
				}
			},
			fields: ['id', 'code', 'label']
		});
		
		Ext.apply(this, {
			title: '添加日历类型',
			resizable: false,
			modal: true,
		    items: {
		    	xtype: 'form',
		        bodyPadding: '9 9 0',
		        bodyStyle: {
		        	background: 'transparent'
		        },
		        border: 0,
		    	items: [{
		    		xtype: 'textfield',
		    		fieldLabel: '日历类型名称',
		            name: 'typeName',
		            anchor: '95%',
		            allowBlank: false
		    	}, {
		    		xtype: 'grid',
		    		title: false,
		    	    store: gridstore,
		    	    columns: [
		    	        {header: '工作日历参数类型',  dataIndex: 'name', flex: 1, 
		    	        	editor: {
		    	        		xtype: 'combobox',
		    	        		store: paramTypeStore,
		    	        		allowBlank: false,
		    	        		displayField: 'label',
		    	        	    valueField: 'label',
		    	        	    listeners: {
		    	        	    	select: function( combo, records, eOpts ) {
		    	        	    		combo.ownerCt.query('combobox[name=email]')[0].clearValue();
		    	        	    		paramByParamTypeStore.getProxy().setExtraParam( "paramType", records[0].raw.type );
		    	        	    		paramByParamTypeStore.load();
		    	        	    	}
		    	        	    }
		    	        	}
		    	        },
		    	        {header: '工作日历参数', dataIndex: 'email', flex: 1,
		    	            editor: {
		    	                xtype: 'combobox',
		    	                store: paramByParamTypeStore,
		    	        		allowBlank: false,
		    	        		displayField: 'label',
		    	        	    valueField: 'label'
		    	            }
		    	        }
		    	    ],
		    	    plugins: [
    	              	rowEditing
		    	    ],
		    	    height: 200,
		    	    width: 500,
		    	    tbar: [{
						xtype: 'button',
						text: '添加',
						handler: function(button, e) {
							if(!editingFlag) {
								editingFlag = true;
								gridstore.insert(0, {});
								rowEditing.startEdit(0, 0);
							}
						}
					}, {
						xtype: 'button',
						text: '删除',
						handler: function(button, e) {
							if(!editingFlag) {
								var sm = this.up('grid').getSelectionModel();
				                rowEditing.cancelEdit();
				                gridstore.remove(sm.getSelection());
				                if (gridstore.getCount() > 0) {
				                    sm.select(0);
				                }
							}
						}
					}],
		    	}],
		    	buttonAlign: 'center',
		    	buttons: [{
		            text: '保存',
		            formBind: true,
		            handler: function() {
		            	var form = this.up('form').getForm();
		                if (form.isValid()) {
		                	var r = gridstore.getModifiedRecords();
		                	/*
		                    form.submit({
		                    	url: contextPath + '/demo/WorkingCalendarMaintainController/addWorkingCalendarType',
		                        success: function(form, action) {
		                           Ext.Msg.alert('Success', action.result.message);
		                        },
		                        failure: function(form, action) {
		                            Ext.Msg.alert('Failed', action.result.message);
		                        }
		                    });
		                    */
		                	var t;
		                }
		            }
		        }]
		    }
		});
		this.callParent(arguments);
	}
	
	
	
});