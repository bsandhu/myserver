curl = {baseUrl: window.location.origin + '/myserver/resources/js/',
        paths: {/** Core libs */
                "jquery"    : "lib/jquery-1.9.1.js",
                "knockout"  : "lib/knockout-2.2.1.js",

                /** Widget libs */
                "jqueryui"  : "lib/jquery-ui-1.10.3.custom.js",
                "kendo.web" : "lib/kendo.web.js",

                /** KO plugins/bindings */
                "ko-amd-helpers": "lib/knockout-amd-helpers.js",
                "ko-jqueryui"   : "lib/knockout-jqueryui.js",
                "ko-kendoui"    : "lib/knockout-kendo.js",
                "ko-bindings"   : "lib/knockoutbindings.js",

                /** Postal (pub-sub) */
                "postal" : "lib/postal.js",
                "postaldiags" : "lib/postal.diagnostics.js",

                /** Atmosphere */
                "jquery-atmosphere": "lib/jquery.atmosphere.js",

                /** Curl plugins */
                "text": "lib/text",

                /** Jasmine tests */
                "jasmine"     : "lib/jasmine.js",
                "jasmine-html": "lib/jasmine-html.js",

                /** Utils */
                log: "lib/log4javascript.js",
                "stringjs": "lib/string.js",
                "underscoreNonAMD": "lib/underscoreNonAMD.js",
                "underscore": "lib/underscore.js"}
        };