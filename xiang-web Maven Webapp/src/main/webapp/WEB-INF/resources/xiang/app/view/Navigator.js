
Ext.define('Xiang.view.Navigator', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.navigator',
    
    layout: 'fit',
    useArrows: true,
    rootVisible: false,
    store: Ext.create('Ext.data.TreeStore', {
    	autoLoad: true,
    	defaultRootText: 'Xiang',
    	proxy: {
            type: 'ajax',
            url: 'demo/ViewportController/navigator'
        },
        root: {
            expanded: true
        }
    })
});