(function(module) {
try {
  module = angular.module('poPartials');
} catch (e) {
  module = angular.module('poPartials', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/partials/rhReports.html',
    '<div class="card cardRow">\n' +
    '    <form ng-submit="rhrSearchForm.$valid && rhrCtrl.search()" name="rhrSearchForm">\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-1"></div>\n' +
    '            <div class="col-md-10">\n' +
    '                <h3>Resource hours Report</h3>\n' +
    '            </div>\n' +
    '            <div class="col-md-1"></div>\n' +
    '        </div>\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-12 form-inline">\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-radio-group ng-model="rhrCtrl.selectionBy" layout="row">\n' +
    '                        <md-radio-button value="Manager" class="md-primary" [checked]=\'true\'>Manager</md-radio-button>\n' +
    '                        <md-radio-button value="Project"> Project </md-radio-button>\n' +
    '                    </md-radio-group>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-autocomplete ng-if="rhrCtrl.selectionBy == \'Manager\'" flex required md-input-name="autocompleteManager" md-min-length="2"\n' +
    '                        md-delay="300" md-selected-item="rhrCtrl.searchParam.selectedEmployee" md-autoselect="true" md-search-text="rhrCtrl.employeeText"\n' +
    '                        md-select-on-match="true" md-match-case-insensitive="true" md-items="employee in rhrCtrl.employees" md-floating-label="Select an Employee"\n' +
    '                        md-item-text="employee.display" md-search-text-change="rhrCtrl.getEmployees(rhrCtrl.employeeText)">\n' +
    '                        <md-item-template>\n' +
    '                            <span md-highlight-flags="^i" md-highlight-text="rhrCtrl.employeeText">{{employee.display}}</span>\n' +
    '                        </md-item-template>\n' +
    '                        <md-not-found>No matches found.</md-not-found>\n' +
    '                        <div ng-messages="rhrSearchForm.autocompleteManager.$error" ng-if="rhrSearchForm.autocompleteManager.$touched">\n' +
    '                            <div ng-message="required">You\n' +
    '                                <b>must</b> select an employee.</div>\n' +
    '                        </div>\n' +
    '                    </md-autocomplete>\n' +
    '                    <md-autocomplete ng-if="rhrCtrl.selectionBy == \'Project\'" flex required md-input-name="autocompleteProject" md-min-length="3"\n' +
    '                        md-delay="300" md-selected-item="rhrCtrl.searchParam.selectedProject" md-autoselect="true" md-search-text="rhrCtrl.projectText"\n' +
    '                        md-select-on-match="true" md-match-case-insensitive="true" md-items="project in rhrCtrl.projects" md-floating-label="Select a project"\n' +
    '                        md-item-text="project.display" md-search-text-change="rhrCtrl.getParentProjects(rhrCtrl.projectText)">\n' +
    '                        <md-item-template>\n' +
    '                            <span md-highlight-flags="^i" md-highlight-text="rhrCtrl.projectText">{{project.display}}</span>\n' +
    '                        </md-item-template>\n' +
    '                        <md-not-found>No matches found.</md-not-found>\n' +
    '                        <div ng-messages="rhrSearchForm.autocompleteProject.$error" ng-if="rhrSearchForm.autocompleteProject.$touched">\n' +
    '                            <div ng-message="required">You\n' +
    '                                <b>must</b> select a project.</div>\n' +
    '                        </div>\n' +
    '                    </md-autocomplete>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container class="md-block">\n' +
    '                        <!-- <label>Operator</label>\n' +
    '                        <md-select ng-model="rhrCtrl.searchParam.selectedOperator" required>\n' +
    '                            <md-option ng-repeat="operator in rhrCtrl.operators" ng-value="operator.value">{{operator.text}}</md-option>\n' +
    '                        </md-select> -->\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container class="md-block">\n' +
    '                        <!-- <label>Hours</label>\n' +
    '                        <input name="searchHour" ng-model="rhrCtrl.searchParam.hours" required ng-pattern="/^\\d+([,.]\\d+)?$/" >\n' +
    '                        <div ng-messages="rhrSearchForm.searchHour.$error" role="alert" multiple>\n' +
    '                            <div ng-message="required" class="my-message">You must supply Hours.</div>\n' +
    '                            <div ng-message="pattern" class="my-message">That doesn\'t look like a Number.\n' +
    '                            </div>\n' +
    '                            <div ng-message="md-maxlength" class="my-message">\n' +
    '                                We use only 3 digit number\n' +
    '                            </div>\n' +
    '                        </div> -->\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-12 form-inline">\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-radio-group ng-model="rhrCtrl.selectionByDate" layout="row">\n' +
    '                        <md-radio-button value="lastWeek" class="md-primary" [checked]=\'true\'>Last week</md-radio-button>\n' +
    '                        <md-radio-button value="dateRange">Date Range </md-radio-button>\n' +
    '                    </md-radio-group>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rhrCtrl.searchParam.searchFromDate" md-placeholder="Enter date" ng-disabled="rhrCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rhrCtrl.searchParam.searchToDate" md-placeholder="Enter date" ng-disabled="rhrCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <button type="submit" class="btn btn-default">Search</button>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <md-input-container>\n' +
    '                        <button ng-click="rhrCtrl.export($event)" ng-disabled="rhrCtrl.exportDisabled" class="btn btn-default">Export</button>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <div class="custom-csv-link-location">\n' +
    '                        <span class="ui-grid-exporter-csv-link">&nbsp;</span>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '\n' +
    '\n' +
    '\n' +
    '        <!-- <div class="form-group container-fluid">\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <label>Employee</label>\n' +
    '                        <md-select ng-model="rhrCtrl.searchParam.selectedEmp" required>\n' +
    '                            <md-option ng-repeat="employee in rhrCtrl.employees" value="{{employee.id}}">{{employee.name}}</md-option>\n' +
    '                        </md-select>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rhrCtrl.searchParam.searchFromDate" md-placeholder="Enter date" required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rhrCtrl.searchParam.searchToDate" md-placeholder="Enter date" required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <button type="submit" class="btn btn-default">Search</button>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '            </div> -->\n' +
    '    </form>\n' +
    '\n' +
    '    <div class="row">\n' +
    '        <div class="col-md-12">\n' +
    '            <div class="col-md-2" style="height: 30px;">\n' +
    '                <span style="color:red">{{rhrCtrl.gridMessage}}</span>\n' +
    '            </div>\n' +
    '            <div class="col-md-8">\n' +
    '                <div id="grid1" ui-grid="rhrCtrl.gridOptions" ui-grid-selection ui-grid-exporter style="height:55vh; width:148vh;"></div>\n' +
    '            </div>\n' +
    '            <div class="col-md-2"></div>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</div>');
}]);
})();

(function(module) {
try {
  module = angular.module('poPartials');
} catch (e) {
  module = angular.module('poPartials', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/partials/rurReports.html',
    '<div class="card cardRow">\n' +
    '    <form ng-submit="rurCtrl.search()" name="searchForm">\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-1"></div>\n' +
    '            <div class="col-md-10">\n' +
    '                <h3>Resource utilisation Report</h3>\n' +
    '            </div>\n' +
    '            <div class="col-md-1"></div>\n' +
    '        </div>\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-12 form-inline">\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-radio-group ng-model="rurCtrl.selectionBy" layout="row">\n' +
    '                        <md-radio-button value="Manager" class="md-primary" [checked]=\'true\'>Manager</md-radio-button>\n' +
    '                        <md-radio-button value="Project"> Project </md-radio-button>\n' +
    '                    </md-radio-group>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-autocomplete ng-if="rurCtrl.selectionBy == \'Manager\'" flex required md-input-name="autocompleteManager" md-min-length="2" md-delay="300" md-selected-item="rurCtrl.searchParam.selectedEmployee"\n' +
    '                        md-autoselect="true" md-search-text="rurCtrl.employeeText" md-select-on-match="true" md-match-case-insensitive="true"\n' +
    '                        md-items="employee in rurCtrl.employees" md-floating-label="Select an Employee" md-item-text="employee.display"\n' +
    '                        md-search-text-change="rurCtrl.getEmployees(rurCtrl.employeeText)">\n' +
    '                        <md-item-template>\n' +
    '                            <span md-highlight-flags="^i" md-highlight-text="rurCtrl.employeeText">{{employee.display}}</span>\n' +
    '                        </md-item-template>\n' +
    '                        <md-not-found>No matches found.</md-not-found>\n' +
    '                        <div ng-messages="searchForm.autocompleteManager.$error" ng-if="searchForm.autocompleteManager.$touched">\n' +
    '                            <div ng-message="required">You <b>must</b> select an employee.</div>\n' +
    '                          </div>\n' +
    '                    </md-autocomplete>\n' +
    '                    <md-autocomplete ng-if="rurCtrl.selectionBy == \'Project\'" flex required md-input-name="autocompleteProject" md-min-length="3" md-delay="300" md-selected-item="rurCtrl.searchParam.selectedProject"\n' +
    '                        md-autoselect="true" md-search-text="rurCtrl.projectText" md-select-on-match="true" md-match-case-insensitive="true"\n' +
    '                        md-items="project in rurCtrl.projects" md-floating-label="Select a project" md-item-text="project.display"\n' +
    '                        md-search-text-change="rurCtrl.getParentProjects(rurCtrl.projectText)">\n' +
    '                        <!-- <md-item-template>\n' +
    '                            <span md-highlight-flags="^i" md-highlight-text="rurCtrl.projectText">{{project.display}}</span>\n' +
    '                        </md-item-template> -->\n' +
    '                        <md-item-template>{{project.display}} </md-item-template>\n' +
    '                        <md-not-found>No matches found.</md-not-found>\n' +
    '                        <div ng-messages="searchForm.autocompleteProject.$error" ng-if="searchForm.autocompleteProject.$touched">\n' +
    '                            <div ng-message="required">You <b>must</b> select a project.</div>\n' +
    '                          </div>\n' +
    '                    </md-autocomplete>\n' +
    '                </div>\n' +
    '                <div class="col-md-6"></div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-12 form-inline">\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-radio-group ng-model="rurCtrl.selectionByDate" layout="row">\n' +
    '                        <md-radio-button value="lastWeek" class="md-primary" [checked]=\'true\'>Last week</md-radio-button>\n' +
    '                        <md-radio-button value="dateRange">Date Range </md-radio-button>\n' +
    '                    </md-radio-group>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rurCtrl.searchParam.searchFromDate" md-placeholder="Enter date" ng-disabled="rurCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rurCtrl.searchParam.searchToDate" md-placeholder="Enter date" ng-disabled="rurCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <button type="submit" class="btn btn-default">Search</button>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <md-input-container>\n' +
    '                        <button ng-click="rurCtrl.export($event)" ng-disabled="rurCtrl.exportDisabled" class="btn btn-default">Export</button>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <div class="custom-csv-link-location">\n' +
    '                        <span class="ui-grid-exporter-csv-link">&nbsp;</span>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '\n' +
    '\n' +
    '\n' +
    '        <!-- <div class="form-group container-fluid">\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <label>Employee</label>\n' +
    '                        <md-select ng-model="rurCtrl.searchParam.selectedEmp" required>\n' +
    '                            <md-option ng-repeat="employee in rurCtrl.employees" value="{{employee.id}}">{{employee.name}}</md-option>\n' +
    '                        </md-select>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rurCtrl.searchParam.searchFromDate" md-placeholder="Enter date" required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="rurCtrl.searchParam.searchToDate" md-placeholder="Enter date" required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-3">\n' +
    '                    <md-input-container>\n' +
    '                        <button type="submit" class="btn btn-default">Search</button>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '            </div> -->\n' +
    '    </form>\n' +
    '\n' +
    '    <div class="row">\n' +
    '        <div class="col-md-12">\n' +
    '            <div class="col-md-2" style="height: 30px;">\n' +
    '                <span style="color:red">{{rurCtrl.gridMessage}}</span>\n' +
    '            </div>\n' +
    '            <div class="col-md-8">\n' +
    '                <div id="grid1" ui-grid="rurCtrl.gridOptions" ui-grid-selection ui-grid-exporter style="height:55vh; width:148vh;"></div>\n' +
    '            </div>\n' +
    '            <div class="col-md-2"></div>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</div>');
}]);
})();

(function(module) {
try {
  module = angular.module('poPartials');
} catch (e) {
  module = angular.module('poPartials', []);
}
module.run(['$templateCache', function($templateCache) {
  $templateCache.put('/partials/tsReports.html',
    '<div class="card cardRow">\n' +
    '    <form ng-submit="tsrCtrl.search()">\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-1"></div>\n' +
    '            <div class="col-md-10">\n' +
    '                <h3>Timesheet Reports for ISO-016-PCI </h3>\n' +
    '            </div>\n' +
    '            <div class="col-md-1"></div>\n' +
    '        </div>\n' +
    '\n' +
    '        <div class="row">\n' +
    '            <div class="col-md-12 form-inline">\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-radio-group ng-model="tsrCtrl.selectionByDate" layout="row">\n' +
    '                        <md-radio-button value="lastWeek" class="md-primary" [checked]=\'true\'>Last week</md-radio-button>\n' +
    '                        <md-radio-button value="dateRange">Date Range </md-radio-button>\n' +
    '                    </md-radio-group>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="tsrCtrl.searchParam.searchFromDate" md-placeholder="Enter date" ng-disabled="tsrCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-2">\n' +
    '                    <md-input-container>\n' +
    '                        <md-datepicker ng-model="tsrCtrl.searchParam.searchToDate" md-placeholder="Enter date" ng-disabled="tsrCtrl.disableDate"\n' +
    '                            md-open-on-focus required></md-datepicker>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <button type="submit" class="btn btn-default">Search</button>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <md-input-container>\n' +
    '                        <button ng-click="tsrCtrl.export($event)" ng-disabled="tsrCtrl.exportDisabled" class="btn">Export</button>\n' +
    '                    </md-input-container>\n' +
    '                </div>\n' +
    '                <div class="col-md-1">\n' +
    '                    <div class="custom-csv-link-location">\n' +
    '                        <span class="ui-grid-exporter-csv-link">&nbsp;</span>\n' +
    '                    </div>\n' +
    '                </div>\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </form>\n' +
    '    <div class="row">\n' +
    '        <div class="col-md-12">\n' +
    '            <div class="col-md-8"></div>\n' +
    '            <div class="col-md-2">\n' +
    '\n' +
    '            </div>\n' +
    '            <div class="col-md-2"></div>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '    <div class="row">\n' +
    '        <div class="col-md-12">\n' +
    '            <div class="col-md-2" style="height: 30px;">\n' +
    '                <!-- <div ng-show="tsrCtrl.gridStatusVisible" id="loadingWidget" class="row-fluid ui-corner-all" style="padding: 0 .7em;" loading-widget>\n' +
    '                    <div class="form-inline">\n' +
    '                        <p>\n' +
    '                            <img alt="Loading  Content" src="images/ajax-loader.gif" /> Loading\n' +
    '                        </p>\n' +
    '                    </div>\n' +
    '                </div> -->\n' +
    '                <span style="color:red">{{tsrCtrl.gridMessage}}</span>\n' +
    '            </div>\n' +
    '\n' +
    '            <div class="col-md-8">\n' +
    '                <div id="grid1" ui-grid="tsrCtrl.gridOptions" ui-grid-selection ui-grid-exporter style="height:64vh; width:148vh;"></div>\n' +
    '            </div>\n' +
    '            <div class="col-md-2"></div>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</div>');
}]);
})();
