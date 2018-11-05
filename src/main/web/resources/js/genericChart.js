$('document').ready(function () {
    var
        canv = $('canvas')[0],
        ctx = canv.getContext('2d');

    clearChart(ctx, canv);
});