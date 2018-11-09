$('document').ready(function () {
    var
        canv = $('canvas')[0],
        ctx = canv.getContext('2d');

    updateChart();

    var x1, y1;

    $('#canv').on('mousedown', function (e) {
        var pos = getMousePos(canv, e);
        x1 = pos.x;
        y1 = pos.y;
        ctx.fillStyle = "red";
        ctx.beginPath();
        ctx.arc(x1, y1, 1, 0, Math.PI * 2);
        ctx.fill();
        document.getElementById('jsfForm:y_value').value = (150-y1)/20;
        document.getElementById('jsfForm:hidden_x').value = (x1-150)/20;
        document.getElementById("jsfForm").submit();
    });

    $('input:radio').click(function () {
        document.getElementById('jsfForm:hidden_x').value = this.value;
    })

});

function getMousePos(canv, e) {
    var rect = canv.getBoundingClientRect();
    return {
        x: e.clientX - rect.left,
        y: e.clientY - rect.top
    };
}

function updateChart() {
    var
        canv = $('canvas')[0],
        ctx = canv.getContext('2d');


    var xValues = [],
        yValues = [],
        isInArea = [];

    var i = 0;

    $('.hitsTableXColumn').each(function() {
        xValues[i++] = parseFloat($(this).html());
    });

    i = 0;

    $('.hitsTableYColumn').each(function() {
        yValues[i++] = parseFloat($(this).html());
    });

    i = 0;

    $('.hitsTableCheckColumn').each(function() {
        isInArea[i++] = $(this).html();
    });

    drawArea(PF('spin').value, ctx, canv);
    drawAxis(ctx);
    drawArrows(ctx);
    drawTips(ctx);
    drawXValues(ctx);
    drawYValues(ctx);
    drawPreviousHits(xValues, yValues, isInArea, ctx);
}

function drawArea(R, ctx, canv){
    ctx.clearRect(0, 0, canv.width, canv.height);
    ctx.fillStyle = "#3399FF";
    ctx.save();
    ctx.translate(canv.width / 2, canv.height / 2);
    ctx.beginPath();
    ctx.arc(0, 0, R/2 * 20, 0, Math.PI * 2);
    ctx.restore();
    ctx.fill();
    ctx.fillStyle = "white";
    ctx.fillRect(150 + 0.5, 0 , 150-0.5, 300);
    ctx.fillRect(0, 0, 150 + 0.5, 149 + 0.5);
    ctx.fillStyle = "#000";
    ctx.strokeRect(0, 0, 300, 300);
    ctx.fillStyle = "#3399FF";
    ctx.fillRect(150-R*20, 150-(R/2)*20 - 1, R*20, (R/2)*20);
    ctx.beginPath();
    ctx.moveTo(150, 150);
    ctx.lineTo(150, 150+2.5+R*20);
    ctx.lineTo(151+(R/2)*20, 150);
    ctx.closePath();
    ctx.fill();
    ctx.fillStyle = "#000";
}

function drawPreviousHits(xValues, yValues, isInArea, ctx) {
    for (i = 0; i< xValues.length; ++i){
        var str = isInArea[i];
        str = str.trim(" ");
        if (str.localeCompare("false") != 0) {
            ctx.fillStyle = "#11FF00";
        } else {
            ctx.fillStyle = "red";
        }
        ctx.beginPath();
        ctx.arc(xValues[i] * 20 + 150+0.5, 150 - yValues[i] * 20 - 0.5, 1, 0, Math.PI * 2);
        ctx.fill();
    }
    ctx.fillStyle = "#000";
}