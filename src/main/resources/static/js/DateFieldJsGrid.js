var MyDateField = function(config) {
    jsGrid.Field.call(this, config);
};

MyDateField.prototype = new jsGrid.Field({
    sorter: function(date1, date2) {
        return new Date(date1) - new Date(date2);
    },

    itemTemplate: function(value) {
        var d = new Date(value);
         return d.getDate()  + "/" + (d.getMonth()) + "/" + d.getFullYear();
    },

    insertTemplate: function(value) {
        return this._insertPicker = $("<input>").datepicker({ defaultDate: new Date() });
    },

    editTemplate: function(value) {
        return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
    },

    insertValue: function() {
        return this._insertPicker.datepicker("getDate").toISOString();
    },

    editValue: function() {
        return this._editPicker.datepicker("getDate").toISOString();
    }
});

jsGrid.fields.dateField = MyDateField;