<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
    <asset:javascript src="Chart.min.js"/>
</head>


    <body>
        <div class="container">
            <div class="row">
            <h2>Testergebnisse: </H2>
            <p>Fehler: ${fails}</p>
            </div>
            <div class="row">
                <canvas id="myChart" width="400" height="200"></canvas>
                <script>
                    var ctx = document.getElementById('xxmyChart').getContext('2d');
                    var myChart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                            datasets: [{
                                label: '# of Votes',
                                data: [12, 19, 3, 5, 2, 3],
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)',
                                    'rgba(153, 102, 255, 0.2)',
                                    'rgba(255, 159, 64, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255, 99, 132, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(153, 102, 255, 1)',
                                    'rgba(255, 159, 64, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                </script>
            </div>
        </div>
    </body>
    <script>
    var ctx2 = document.getElementById("myChart").getContext('2d');
    var todayChart = new Chart(ctx2, {
    type: 'line',
    data: {
        labels: ['m', 'm', 'm', 'm', 'm'],
        datasets: [{
            label: 'Temperatur',
            fill: false,
            borderColor: "rgba(255,0,0,1)",
            backgroundColor: "rgba(255,0,0,1)",
            data: [{x:1,y:1},{x:2,y:4},{x:3,y:9},{x:4,y:16},{x:5,y:25}]
        }]
    },
    options: {
        scales: {
            yAxes: [{
                gridLines: {
                    color: 'gray'
                },
                ticks: {
                    beginAtZero:true
                }
            }],
            xAxes: [{
                gridLines: {
                    color: 'gray'
                }
            }]
        }
    }
});

    </script>
</html> 