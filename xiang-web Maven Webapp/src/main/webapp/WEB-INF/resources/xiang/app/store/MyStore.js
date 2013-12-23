
Ext.define('Xiang.store.MyStore', {
	extend: 'Ext.data.Store',
	
	constructor: function (config) {
		var cfg = Ext.Object.merge({
			autoLoad: false,
		    proxy: {
		    	type: 'ajax',
		    	url: undefined,
		        pageParam: undefined,
		        limitParam: undefined,
		        startParam: undefined,
		        filterParam: undefined,
		        noCache: true,
		        reader: {
		            type: 'json',
		            root: undefined,
		            idProperty: undefined
		        }
		    },
		}, config);
		// 添加上下文根
		if(cfg.proxy.url) {
			cfg.proxy.url = contextPath + cfg.proxy.url;
		}
        this.callParent([cfg]);
    }
	
});