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

    <title>Trade app</title>
</head>
<body>
<section>
    <form data-bind="submit: saveTrade">
        <div style="width: 400px; border-width: 1px; border-color: darkolivegreen; border-style: solid">
            <div id="foo" style="display: inline-block; width: 100%" data-bind="visible: _status().length > 0">
                <div data-bind="text: _status" style="display: inline-block; width: 80%"></div>
                <div data-bind="click: resetStatus" style="display: inline-block; width: 18%">X</div>
            </div>

            <div><span class="label">Tranche</span><span><input data-bind="value: trancheId"/></span></div>
            <div><span class="label">Quantity</span><span><input data-bind="value: quantity" type="text"/></span></div>
            <div><span class="label">Price</span><span><input data-bind="value: price" type="text"/></span></div>
            <div>
                <span class="label">Trade Date</span>
                <span><input data-bind="datepicker: { onSelect:onSelect, showWeek:'true', changeMonth:'true', dateFormat:'mm-dd-yy'}, value: tradeDate" type="text"></span>
            </div>
            <div>
                <span class="label">Entry Date</span>
                <span><input data-bind="value: entryDate" type="text" disabled="true"/></span>
            </div>
            <div>
                <span class="label">Book</span><span>
                <input data-bind="value: bookName" type="text"/></span></div>
            <div>
                <span class="label">Counter party</span><span>
                <input data-bind="value: counterParty" type="text"/></span>
            </div>

            <div><span class="label">Notes</span>
                <span><textarea></textarea></span></div>

            <div>
                <span class="label">Buy/Sell</span>
                <span>
                    <select name="Buy/sell">
                        <option>Buy</option>
                        <option>Sell</option>
                    </select>
                </span>
            </div>
            <div style="width: 100%; text-align: right">
                <input style="width: 100px" type="submit" value="Save">
            </div>
        </div>
    </form>
</section>
<section>
</section>
</body>

<script src="resources/js/lib/curlConfig.js"></script>
<script src="resources/js/lib/curl.js"></script>

<script>
    curl(["domReady!", "jquery", "js!jqueryui"])
         .next(["knockout"], function(ko) {
                window['ko'] = ko;
            })
         .next(["js!ko-jqueryui"])
         .next(["knockout", "app/ticket/TicketViewModel"], function (ko, TicketViewModel) {
                ko.applyBindings(new TicketViewModel())
         });
</script>
</html>