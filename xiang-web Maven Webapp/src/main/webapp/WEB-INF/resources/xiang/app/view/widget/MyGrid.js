
Ext.define('Xiang.store.MyGridStore', {
	extend: 'Ext.grid.Panel',
	
	constructor: function (config) {
		var cfg = Ext.Object.merge({
			xtype: 'gridpanel',
			title: 'Grid Title',
			width: '100%',
			height: '100%',
		    forceFit: true,
		    columns: [
		        { text: '序号', xtype: 'rownumberer', minWidth: 36, maxWidth: 36, align: 'center'},
		        { text: '标识', dataIndex: 'id' },
		        { text: '名称', dataIndex: 'typeName' }
		    ],
		    bbar: {
                xtype: 'pagingtoolbar',
                displayInfo: true
            }
		}, config);
        this.callParent([cfg]);
    }
	
});