from django.http import HttpResponse
from django.core import serializers
from django.shortcuts import render_to_response
from django.template import loader, Context

def sim_home(request):
    """
    t = loader.get_template('sim/index.html')
    c = Context()
    data = serializers.serialize("json", t.render(c))
    return HttpResponse(data, mimetype="application/javascript")
    #return HttpResponse(t.render(c))
    #return HttpResponse(t)
    """
    return render_to_response("sim/index.html", {})

