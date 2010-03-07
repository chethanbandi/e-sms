from django.http import HttpResponse
from django.template import loader

def sim_home(request):
    t = loader.get_template('sim/index.html')
    return HttpResponse(t)

