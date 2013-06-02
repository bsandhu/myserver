define(['app/viewModels/EventsViewModel'],
    function (EventsViewModel) {

        describe("EventVM", function () {

            it("should be able to store locally", function () {
                var vm = new EventsViewModel();
                vm.save({'Test': 100});

                expect(localStorage.getItem('EventsHistory')).toEqual('[{"Test":100}]');
                vm.clearHistory();
                expect(localStorage.getItem('EventsHistory')).toEqual('[]');
            });
        });
    });
