Ext.Loader.setConfig({
    enabled: true
});
Ext.Loader.setPath('Ext.ux', 'resources/xiang/extjs/ux');

Ext.application({
	name : 'Xiang',
	appFolder : 'resources/xiang/app',
	controllers : [ 'Viewport' ],
	autoCreateViewport : true,
	launch: function() {
		Ext.create('Xiang.view.workingcalendar.TypeEdit').show();
    }
});