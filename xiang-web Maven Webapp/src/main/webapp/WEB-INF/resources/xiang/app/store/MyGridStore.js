
Ext.define('Xiang.store.MyGridStore', {
	extend: 'Ext.data.Store',
	
	constructor: function (config) {
		var cfg = Ext.Object.merge({
			autoLoad: false,
			pageSize: 10,
		    proxy: {
		    	type: 'ajax',
		    	url: undefined,
		        pageParam: 'page.page',
		        limitParam: 'page.size',
		        startParam: undefined,
		        reader: {
		            type: 'json',
		            root: 'content',
		            totalProperty: 'totalElements'
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