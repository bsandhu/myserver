<div id="tradeBlotterView" style="background-color: ivory; display: block; height: 200px">
    <div data-bind="jqxGrid: {source:trades, autoheight:false,
        disabled: false,
        sortable: true,
        showgroupsheader: true,
        groupable: true,
        autoshowfiltericon: true,
        filterable: true,
        columns: [
        { text: 'tradeDate', datafield: 'tradeDate', width: 180 },
        { text: 'entryDate', datafield: 'entryDate', width: 80 },
        { text: 'counterParty', datafield: 'counterParty', width: 90 },
        { text: 'bookName', datafield: 'bookName', width: 90 },
        { text: 'notes', datafield: 'notes', width: 90 },
        { text: 'price', datafield: 'price', width: 90 },
        { text: 'trancheId', datafield: 'trancheId', width: 100 },
        { text: 'Quantity', datafield: 'quantity', width: 100 },
        { text: 'buySell', datafield: 'buySell', width: 90 }]
        }" id="jqxgrid"></div>
</div>

<%--[{"active":true,"tradeId":"1","quantity":84845.91,"trancheId":408353,"tradeDate":1205985600000,"entryDate":"12/20/05",--%>
<%--"counterParty":"Jaxworks","bookName":"London","notes":"eget tincidunt eget tempus vel pede morbi porttitor--%>
<%--lorem id ligula suspendisse ornare consequat lectus in est risus auctor","price":39.12,"buySell":"Sell"}--%>


