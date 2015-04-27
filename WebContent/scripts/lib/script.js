"use strict";

$(function() {

    $('#getAll_btn').on('click', function() {
        var obj = $.ajax({
            aysnc: true,
            cache: false,

            dataType: 'json',
            error: function(jqXHR, textStatus, error) {
                console.log(error);
            },
            success: function(data, textStatus, jqXHR) {
                console.log(data);
            },
            type: 'GET',
            url: 'rest/people/getAll'
        });

    });
 //}); 



    $('#addPerson_btn').on('click', function() {

        var obj = {  

                            "firstName":"Ramya",
                            "lastName":"Vemuganti", 
                            "email":"ramya_vemuganti@abc.com",
                            "address1": "1531 Sal Drive",
                            "address2": "1321 West Bluemound Rd",
                            "city": "",
                            "zip": 33109,
                           "phone": "6087751134",
                           "state": "New York",
                            
                            };

        var obj = $.ajax({
            aysnc: true,
            cache: false,
            contentType: 'application/json',
            data: JSON.stringify(obj),
            datatype: 'json',

            dataType: 'json',
            error: function(jqXHR, textStatus, error) {
                console.log(error);
            },
            success: function(data, textStatus, jqXHR) {
                console.log(data);
            },
            type: 'POST',
            url: 'rest/people/add'
        });

    });  
 
    });  
