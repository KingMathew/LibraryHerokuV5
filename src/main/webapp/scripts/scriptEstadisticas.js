$(document).ready(function () {

    $.ajax({
        url: "../ElementosPorArea",
        type: "GET",
        dataType: "json"

    }).done(function (response) {
        console.log(response);
        var arr = [];
        arr = response;

        var datos = {
            datasets: [{
                    label: arr[0].area,
                    backgroundColor: '#f4511e',
                    data: [arr[0].cantidadDisponible]
                },
                {

                    label: arr[1].area,
                    backgroundColor: "rgba(123,187,205,1)",
                    data: [arr[1].cantidadDisponible]
                },
                {
                    label: arr[2].area,
                    backgroundColor: "rgba(230,100,205,1)",
                    data: [arr[2].cantidadDisponible]
                },
                {

                    label: arr[3].area,
                    backgroundColor: "rgba(0, 230, 118, 1)",
                    data: [arr[3].cantidadDisponible]
                }
            ]
        };




        var canvas = document.getElementById('chart').getContext('2d');
        window.bar = new Chart(canvas, {
            type: "bar",
            data: datos,
            options: {
                elements: {
                    rectangle: {
                        borderWidth: 1,
                        borderSkipped: 'bottom'
                    }
                },
                responsive: true,
                title: {
                    display: true,
                    text: "Más de 700 menos de 2.000"
                }
            }
        });

    });
});
$(document).ready(function () {

    $.ajax({
        url: "../ElementosPorArea",
        type: "GET",
        dataType: "json"

    }).done(function (response) {
        console.log(response);
        var arr = [];
        arr = response;

        var datos = {
            datasets: [{
                    label: arr[4].area,
                    backgroundColor: "#4E342E",
                    data: [arr[4].cantidadDisponible]
                },
                {

                    label: arr[5].area,
                    backgroundColor: "rgba(123,187,205,1)",
                    data: [arr[5].cantidadDisponible]
                },
                {
                    label: arr[6].area,
                    backgroundColor: "rgba(230,100,205,1)",
                    data: [arr[6].cantidadDisponible]
                },
                {

                    label: arr[7].area,
                    backgroundColor: "rgba(240,187,205,1)",
                    data: [arr[7].cantidadDisponible]
                },
                {
                    label: arr[8].area,
                    backgroundColor: "rgba(100,100,205,1)",
                    data: [arr[8].cantidadDisponible]
                },
                {

                    label: arr[9].area,
                    backgroundColor: "rgba(151,187,205,1)",
                    data: [arr[9].cantidadDisponible]
                },
                {
                    label: arr[10].area,
                    backgroundColor: "rgba(210,100,205,1)",
                    data: [arr[10].cantidadDisponible]
                }
            ]
        };




        var canvas = document.getElementById('chart2').getContext('2d');
        window.bar = new Chart(canvas, {
            type: "bar",
            data: datos,
            options: {
                elements: {
                    rectangle: {
                        borderWidth: 1,
                        borderSkipped: 'bottom'
                    }
                },
                responsive: true,
                title: {
                    display: true,
                    text: "Más de 150 menos de 700"
                }
            }
        });

    });
});
$(document).ready(function () {

    $.ajax({
        url: "../ElementosPorArea",
        type: "GET",
        dataType: "json"

    }).done(function (response) {
        console.log(response);
        var arr = [];
        arr = response;

        var datos = {
            datasets: [{
                    label: arr[11].area,
                    backgroundColor: '#f4511e',
                    data: [arr[11].cantidadDisponible]
                },
                {

                    label: arr[12].area,
                    backgroundColor: "#689F38",
                    data: [arr[12].cantidadDisponible]
                },
                {
                    label: arr[13].area,
                    backgroundColor: "#CDDC39",
                    data: [arr[13].cantidadDisponible]
                },
                {

                    label: arr[14].area,
                    backgroundColor: "#FB8C00",
                    data: [arr[14].cantidadDisponible]
                },
                {

                    label: arr[15].area,
                    backgroundColor: "#607D8B",
                    data: [arr[15].cantidadDisponible]
                },
                {

                    label: arr[16].area,
                    backgroundColor: "#7A1EA1",
                    data: [arr[16].cantidadDisponible]
                },
                {

                    label: arr[17].area,
                    backgroundColor: "#039BE5",
                    data: [arr[17].cantidadDisponible]
                },
                {

                    label: arr[18].area,
                    backgroundColor: "#D500F9",
                    data: [arr[18].cantidadDisponible]
                },
                {

                    label: arr[19].area,
                    backgroundColor: "#880E4F",
                    data: [arr[19].cantidadDisponible]
                },
                {

                    label: arr[20].area,
                    backgroundColor: "#C62828",
                    data: [arr[20].cantidadDisponible]
                }

            ]
        };




        var canvas = document.getElementById('chart3').getContext('2d');
        window.bar = new Chart(canvas, {
            type: "bar",
            data: datos,
            options: {
                elements: {
                    rectangle: {
                        borderWidth: 1,
                        borderSkipped: 'bottom'
                    }
                },
                responsive: true,
                title: {
                    display: true,
                    text: "Menos de 150"
                }
            }
        });

    });
});

