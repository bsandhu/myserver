/**
 * Created with IntelliJ IDEA.
 * User: baljeetsandhu
 * Date: 5/29/13
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
define(["jquery", "log"],
    function ($, log) {
        "use strict";

        var obj = {};
        obj.start = function () {
            var request = new $.atmosphere.AtmosphereRequest();
            var socket  = $.atmosphere;
            request.url = document.location.origin + '/myserver/trades/updates';
//            request.contentType = "application/json";
            request.transport = 'websocket';

            request.fallbackTransport = 'long-polling';
            request.onMessage = function (response) {
                var message = response.responseBody;
                try {
//                    var json = JSON.parse(message);
                    log.info("Response: " + response);
                    log.info("Msg: " + message);
                } catch (e) {
                    log.error('Error: ', message.data);
                    return;
                }
            };

            request.onOpen = function (response) {
                log.info("Connection open: " + response);
            };

            request.onError = function (response) {
                log.error("Updates listener error: " + response);
                socket.disconnect();
            };

            request.onClose = function (response) {
                log.error("Socket close. Disconnecting: " + response);
                socket.close();
            }

            log.debug('Subscribing to trade updates..');
            socket.subscribe(request);
            log.debug('Done');

        };
        return obj;
    });
