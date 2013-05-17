<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="resources/css/app.css"/>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="resources/js/lib/jqwidgets/styles/jqx.base.css" type="text/css"/>
    <link rel="stylesheet" href="resources/js/lib/jqwidgets/styles/jqx.darkblue.css" type="text/css"/>

    <title>HTML5 - POC</title>
    <script src="resources/js/lib/curlConfig.js"></script>
    <script src="resources/js/lib/curl.js"></script>
</head>
<body>
    <div id="jqxsplitter"
         data-bind="jqxSplitter:{}">
        <%@include file="TicketView.jsp"%>
        <%@include file="TradeBlotterView.jsp"%>
    </div>
</body>

<script>
    curl(["domReady!", "jquery"])
            .next(["js!jqueryui"])
            .next(["knockout"], function (ko) {
                window['ko'] = ko;
            })
            .next(["js!jqxcore"])
            .next(["js!jqxbuttons", "js!jqxsplitter", "js!jqxgrid", "js!jqxdata", "js!jqxscrollbar", "js!jqxmenu",
                   "js!jqxlistbox", "js!jqxdropdownlist"])
            .next(["js!jqxgrid.selection", "js!jqxgrid.columnsresize", "js!jqxgrid.filter", "js!jqxgrid.sort", "js!jqxgrid.pager", "js!jqxgrid.grouping"])
            .next(["js!ko-jqueryui", "js!ko-jqx", "ko-bindings"])
            .next(["knockout",
                    "app/ticket/TicketViewModel",
                    "app/blotter/TradeBlotterViewModel",
                    "jquery"],function (ko, TicketViewModel, TradeBlotterViewModel, $) {

                ko.applyBindingsToNode(document.getElementById("jqxsplitter"));
                ko.applyBindings(new TicketViewModel(), document.getElementById("ticketView"));
                ko.applyBindings(new TradeBlotterViewModel(), document.getElementById("tradeBlotterView"));
            });
</script>
</html>
