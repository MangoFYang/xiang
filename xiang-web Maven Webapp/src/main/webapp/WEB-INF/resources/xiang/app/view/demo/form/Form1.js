
Ext.define('Xiang.view.demo.form.Form1', {
	extend : 'Ext.form.Panel',

	title : 'Form Title',
	layout : 'anchor',
	bodyPadding : '10',
	defaultType : 'textfield',
	fieldDefaults: {
        // labelAlign: 'top'
    },
	items: [{
        xtype: 'container',
        layout:'hbox',
        items:[{
            xtype: 'container',
            flex: 1,
            border:false,
            layout: 'anchor',
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'First Name',
                allowBlank: false,
                name: 'first1',
                anchor:'95%'
            }, {
                fieldLabel: 'Company',
                name: 'company1',
                anchor:'95%'
            }]
        },{
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Last Name',
                allowBlank: false,
                name: 'last2',
                anchor:'95%'
            },{
                fieldLabel: 'Email',
                allowBlank: false,
                name: 'email2',
                vtype:'email',
                anchor:'95%'
            }]
        },{
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Last Name',
                allowBlank: false,
                name: 'last3',
                anchor:'95%'
            },{
                fieldLabel: 'Email',
                allowBlank: false,
                name: 'email3',
                vtype:'email',
                anchor:'95%'
            }]
        },{
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Last Name',
                allowBlank: false,
                name: 'last4',
                anchor:'95%'
            },{
                fieldLabel: 'Email',
                allowBlank: false,
                name: 'email4',
                vtype:'email',
                anchor:'95%'
            }]
        }]
    },{
        xtype:'tabpanel',
        plain:true,
        activeTab: 0,
        defaults:{
            bodyPadding: 10
        },
        items:[{
            title:'Personal Details',
            defaults: {
                width: 230
            },
            defaultType: 'textfield',

            items: [{
                fieldLabel: 'First Name',
                name: 'first',
                value: 'Jamie'
            },{
                fieldLabel: 'Last Name',
                name: 'last',
                value: 'Avins'
            },{
                fieldLabel: 'Company',
                name: 'company',
                value: 'Ext JS'
            }, {
                fieldLabel: 'Email',
                name: 'email',
                vtype:'email'
            }]
        },{
            title:'Phone Numbers',
            defaults: {
                width: 230
            },
            defaultType: 'textfield',

            items: [{
                fieldLabel: 'Home',
                name: 'home',
                value: '(888) 555-1212'
            },{
                fieldLabel: 'Business',
                name: 'business'
            },{
                fieldLabel: 'Mobile',
                name: 'mobile'
            },{
                fieldLabel: 'Fax',
                name: 'fax'
            }]
        },{
            cls: 'x-plain',
            title: 'Biography',
            layout: 'fit',
            items: {
                xtype: 'htmleditor',
                name: 'bio2',
                fieldLabel: 'Biography'
            }
        }]
    }],

    buttons: [{
        text: 'Save',
        handler: function() {
            this.up('form').getForm().isValid();
            // console.info(this.up('form').getForm().getValues());
        }
    },{
        text: 'Cancel',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }]

});