function drawAxis(ctx){
    ctx.beginPath();
    ctx.moveTo(150+0.5, 0);
    ctx.lineTo(150+0.5, 300);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(0, 150-0.5);
    ctx.lineTo(300, 150-0.5);
    ctx.stroke();
}

function drawArrows(ctx){
    ctx.beginPath();
    ctx.moveTo(150 + 0.5, 0);
    ctx.lineTo(147 + 0.5, 7);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(150 + 0.5, 0);
    ctx.lineTo(153 + 0.5, 7);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(300, 150-0.5);
    ctx.lineTo(293, 150-3.5);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(300, 150-0.5);
    ctx.lineTo(293, 150+2.5);
    ctx.stroke();
}

function drawTips(ctx) {
    for (i = 10; i <= 290; i+=20){
        ctx.beginPath();
        ctx.moveTo(i+0.5, 150-3);
        ctx.lineTo(i+0.5, 150+2);
        ctx.stroke();
    }
    for(i = 10; i <= 290; i+=20) {
        ctx.beginPath();
        ctx.moveTo(148, i-0.5);
        ctx.lineTo(153, i-0.5);
        ctx.stroke();
    }
}

function drawXValues(ctx) {
    ctx.font = "9px Arial";
    var x = -14;
    for(i = -7; i< 0; ++i) {
        ctx.fillText(i, x += 20, 150-3);
    }
    x+=22;
    for(i = 1; i <= 7; ++i) {
        ctx.fillText(i, x +=20, 150-3);
    }
}

function drawYValues(ctx) {
    ctx.font = "9px Arial";
    var y = -8;
    for(i = 7; i >= -7; --i) {
        if (i != 0) {
            ctx.fillText(i, 154, y+=20);
        } else y+=20;
    }
}

function clearChart(ctx, canv) {
    ctx.clearRect(0, 0, canv.width, canv.height);
    ctx.fillStyle = "#000";
    ctx.strokeRect(0, 0, 300, 300);
    drawAxis(ctx);
    drawArrows(ctx);
    drawTips(ctx);
    drawXValues(ctx);
    drawYValues(ctx);
}