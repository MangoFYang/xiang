
Ext.define('Xiang.view.workingcalendar.TypeEdit', {
	extend: 'Ext.window.Window',
	
	initComponent: function() {
		
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
					root: 'param',
					idProperty: 'id'
				}
			},
			fields: ['id', 'code', 'label']
		});
		
		Ext.apply(this, {
			title: '添加日历类型',
			resizable: true,
			modal: true,
		    items: {
		    	xtype: 'form',
		        bodyPadding: '9 9 0',
		        bodyStyle: {
		        	background: 'transparent'
		        },
		        border: 0,
		    	items: [{
		    		xtype: 'container',
		    		layout: 'hbox',
		    		items: [{
			    		xtype: 'textfield',
			    		fieldLabel: '日历类型名称',
			            name: 'typeName',
			            allowBlank: false,
			            margin: '0 20 0 0'
			    	},{
			    		xtype: 'button',
			    		text: '添加'
			    	}]
		    	}, {
		    		xtype: 'container',
		            layout:'hbox',
		            width: 400,
		            margin: '15 0 0 0',
		            items:[{
		            	flex: 1,
		                xtype: 'panel',
		                title: '日历参数类型',
		                layout: 'anchor',
		                border: 0,
		                defaultType: 'combobox',
		                defaults: {
		                	margin: '5'
		                },
		                items: [{
		                    allowBlank: false,
		                    name: 'first1',
		                    anchor:'100%',
		                    store: paramTypeStore,
		                    displayField: 'label',
	    	        	    valueField: 'label',
		                }, {
		                    name: 'company1',
		                    anchor:'100%',
		                    store: paramTypeStore,
		                    displayField: 'label',
	    	        	    valueField: 'label',
		                }]
		            },{
		            	flex: 1,
		                xtype: 'panel',
		                title: '日历参数',
		                layout: 'anchor',
		                border: 0,
		                defaultType: 'combobox',
		                defaults: {
		                	margin: '5'
		                },
		                items: [{
		                    allowBlank: false,
		                    name: 'last2',
		                    anchor:'100%',
		                    store: paramByParamTypeStore,
		                    displayField: 'label',
	    	        	    valueField: 'label',
		                },{
		                    allowBlank: false,
		                    name: 'email2',
		                    vtype:'email',
		                    anchor:'100%',
		                    store: paramByParamTypeStore,
		                    displayField: 'label',
	    	        	    valueField: 'label',
		                }]
		            }]
		    	}],
		    	buttonAlign: 'center',
		    	buttons: [{
		            text: '保存',
		            formBind: true,
		            handler: function() {
		            	var form = this.up('form').getForm();
		                if (form.isValid()) {
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