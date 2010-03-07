from django.http import HttpResponse
from django.template import loader, Context

def sim_home(request):
    t = loader.get_template('sim/index.html')
    c = Context()
    return HttpResponse(t.render(c))
    #return HttpResponse(t)

