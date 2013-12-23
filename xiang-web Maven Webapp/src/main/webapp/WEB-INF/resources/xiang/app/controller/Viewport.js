
Ext.define('Xiang.controller.Viewport', {
	extend : 'Ext.app.Controller',

	refs : [ {
		ref : 'navigator',
		selector : 'navigator'
	}, {
		ref : 'viewer',
		selector : 'viewer'
	} ],

	init : function() {
		this.control({
            'navigator': {
                itemclick: this.addTab
            }
        });
	},
	
	addTab: function(self, record, index, eOpts) {
		if(record.raw.leaf) {
			var viewer = this.getViewer();
			var tab = viewer.getComponent(record.raw.text);
			if(!tab) {
				var viewName = "Xiang.view." + (record.raw.extraData["viewName"] || "Default");
				tab = Ext.create(viewName, {
					title: record.raw.text,
					itemId: record.raw.text,
					closable: true
				});
				viewer.add(tab);
			}
			viewer.setActiveTab(tab);
		}
	}

});