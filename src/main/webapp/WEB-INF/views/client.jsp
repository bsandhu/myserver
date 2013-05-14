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
            <div data-bind="visible: status.length > 0">
                <span data-bind="text: status"/>
            </div>

            <div><span class="label">Tranche</span><span><input data-bind="value: trancheId"/></span></div>
            <div><span class="label">Quantity</span><span><input type="text"/></span></div>
            <div><span class="label">Price</span><span><input type="text"/></span></div>
            <div><span class="label">Trade Date</span><span><input type="text"/></span></div>
            <div><span class="label">entry Date</span><span><input type="text"/></span></div>
            <div><span class="label">Book</span><span><input type="text"/></span></div>
            <div><span class="label">Counter party</span><span><input type="text"/></span></div>

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
    curl(["knockout", "app/ticket/TicketViewModel", "domReady!"],
         function (ko, TicketViewModel) {
            ko.applyBindings(new TicketViewModel())
        });
</script>
</html>