Ext.define('Xiang.view.demo.Demo', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.demo',
    
    requires: [
       'Ext.ux.DataTip'
    ],
    
    initComponent: function() {
    	Ext.QuickTips.init();
    	var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
        Ext.apply(this, {
        	items: {
        		xtype: 'form',
                layout: 'form',
                header: false,
                collapsible: true,
                url: 'save-form.php',
                frame: false,
                border: 0,
                bodyPadding: '5 5 0',
                layout: {
                    type: 'vbox',
                    align: 'stretch'  // Child items are stretched to full width
                },
                plugins: {
                    ptype: 'datatip'
                },
                fieldDefaults: {
                    msgTarget: 'side',
                    labelWidth: 175
                },
                defaultType: 'textfield',
                items: [{
                    fieldLabel: 'First Name',
                    afterLabelTextTpl: required,
                    name: 'first',
                    allowBlank: false,
                    tooltip: 'Enter your first name'
                },{
                    fieldLabel: 'Last Name',
                    afterLabelTextTpl: required,
                    name: 'last',
                    allowBlank: false,
                    tooltip: 'Enter your last name'
                },{
                    fieldLabel: 'Company',
                    name: 'company',
                    tooltip: "Enter your employer's name"
                }, {
                    fieldLabel: 'Email',
                    afterLabelTextTpl: required,
                    name: 'email',
                    allowBlank: false,
                    vtype:'email',
                    tooltip: 'Enter your email address'
                }, {
                    fieldLabel: 'DOB',
                    name: 'dob',
                    xtype: 'datefield',
                    tooltip: 'Enter your date of birth'
                }, {
                    fieldLabel: 'Age',
                    name: 'age',
                    xtype: 'numberfield',
                    minValue: 0,
                    maxValue: 100,
                    tooltip: 'Enter your age'
                }, {
                    xtype: 'timefield',
                    fieldLabel: 'Time',
                    name: 'time',
                    minValue: '8:00am',
                    maxValue: '6:00pm',
                    tooltip: 'Enter a time'
                }],

                buttons: [{
                    text: 'Save',
                    handler: function() {
                    	this.up('form').getForm().submit({
                    	    clientValidation: true,
                    	    url: 'updateConsignment.php',
                    	    params: {
                    	        newStatus: 'delivered'
                    	    },
                    	    success: function(form, action) {
                    	       Ext.Msg.alert('Success', action.result.msg);
                    	    },
                    	    failure: function(form, action) {
                    	        switch (action.failureType) {
                    	            case Ext.form.action.Action.CONNECT_FAILURE:
                    	                Ext.Msg.alert('Failure', 'Ajax communication failed');
                    	                break;
                    	            case Ext.form.action.Action.SERVER_INVALID:
                    	               Ext.Msg.alert('Failure', action.result.msg);
                    	       }
                    	    }
                    	});
                    }
                },{
                    text: 'Cancel',
                    handler: function() {
                        this.up('form').getForm().reset();
                    }
                }]
        	}
        })
        this.callParent(arguments);
    }
    
});
