<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="resources/css/app.css"/>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="resources/js/lib/jqwidgets/styles/jqx.base.css" type="text/css"/>
    <link rel="stylesheet" href="resources/js/lib/jqwidgets/styles/jqx.darkblue.css" type="text/css"/>

    <title>HTML5 - POC</title>
</head>
<body>
<section>
    <div id="jqxsplitter" style="display: block">
        <div style="height: 30%; min-height:250px; width: 400px; border-width: 1px; border-color: darkolivegreen; border-style: solid; padding: 2px">
            <form data-bind="submit: saveTrade">
                <div id="foo" style="display: inline-block; width: 100%" data-bind="visible: _showStatus">
                    <div data-bind="text: _status" style="display: inline-block; width: 80%"></div>
                    <div data-bind="click: resetStatus" style="display: inline-block; width: 15%">X</div>
                </div>
                <div><span class="label">Tranche Id</span><span><input data-bind="value: trancheId"/></span></div>
                <div><span class="label">Quantity</span><span><input data-bind="value: quantity"
                                                                     type="text"/></span></div>
                <div><span class="label">Price</span><span><input data-bind="value: price" type="text"/></span>
                </div>
                <div>
                    <span class="label">Trade Date</span>
                    <span><input
                            data-bind="datepicker: { onSelect:onSelect, showWeek:'true', changeMonth:'true', dateFormat:'mm-dd-yy'}, value: tradeDate"
                            type="text"></span>
                </div>
                <div>
                    <span class="label">Entry Date</span>
                    <span><input data-bind="value: entryDate" type="text" disabled="true"/></span>
                </div>
                <div>
                    <span class="label">Book</span>
                    <span><select data-bind="options: _bookNames, value:bookName" type="text"></select></span>
                </div>
                <div>
                    <span class="label">Counter party</span>
                    <span><input data-bind="value: counterParty" type="text"/></span>
                </div>
                <div>
                    <span class="label">Notes</span>
                    <span><textarea></textarea></span>
                </div>
                <div>
                    <span class="label">Buy/Sell</span>
                        <span>
                            <select name="Buy/sell">
                                <option>Buy</option>
                                <option>Sell</option>
                            </select>
                        </span>
                </div>
                <div style="float: right">
                    <input type="submit" value="Save" data-bind="jqxButton:{theme:'darkblue', width:'100'}"/>
                </div>
            </form>
        </div>
        <div style="height: 50%; background-color: #e0e0e0; display: block; clear: both">
            <h1>FOO</h1>
        </div>
    </div>
</section>
</body>

<script src="resources/js/lib/curlConfig.js"></script>
<script src="resources/js/lib/curl.js"></script>
<script>
    curl(["domReady!", "jquery"])
            .next(["js!jqueryui"])
            .next(["knockout"], function (ko) {
                window['ko'] = ko;
            })
            .next(["js!ko-jqueryui"])
            .next(["js!jqxcore"])
            .next(["js!jqxbuttons", "js!jqxsplitter", "js!ko-jqx"])
            .next(["knockout", "app/ticket/TicketViewModel", "jquery"], function (ko, TicketViewModel, $) {
                ko.applyBindings(new TicketViewModel());
//                $("#jqxSplitter").jqxSplitter();
            });
</script>
</html>