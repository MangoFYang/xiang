/**
 * The main application viewport, which displays the whole application
 * @extends Ext.Viewport
 */
Ext.define('Xiang.view.Viewport', {
    extend: 'Ext.container.Viewport',
    
    requires: [
       'Xiang.view.Viewer',
       'Xiang.view.Navigator',
       'Xiang.view.widget.MyPaging'
    ],
    
    layout: 'border',
    items: [{
        region: 'north',
        html: '<h1 class="x-panel-header">Page Title</h1>'
    }, {
        region: 'west',
        title: '导航',
        collapsible: true,
        margins: '5 0 5 5',
        split:true,
        width: 230,
        // could use a TreePanel or AccordionLayout for navigational items
        xtype: 'navigator'
    }, {
        region: 'center',
        margins: '5 5 5 0',
        xtype: 'viewer'
    }]

});