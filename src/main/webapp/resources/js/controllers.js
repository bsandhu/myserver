"use strict";

function PhoneListCtrl($scope) {
    $scope.phones = [
        {"name": "Nexus S100",
            "snippet": "Fast just got faster with Nexus S.",
            "age": 100
        },
        {"name": "Motorola XOOM™ with Wi-Fi",
            "snippet": "The Next, Next Generation tablet.",
            "age": 50},
        {"name": "MOTOROLA XOOM™",
            "snippet": "The Next, Next Generation tablet.",
            "age": 200},
    ];
    $scope.tableName = "My Table";
}

function foo() {
    var x = "XXX";
    console.log(x.toLocaleLowerCase());
    for (var i = 0; i <= 10; i++) {
        i++;
    }
    var a = 0;
    [1, 2, 3].forEach(function () {
            a = a + x;
        }
    );
}

