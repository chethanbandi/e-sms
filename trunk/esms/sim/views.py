from django.http import HttpResponse
from django.core import serializers

from sim.models import College

def sim_home(request):
    json_serializer = serializers.get_serializer("json")()
    queryset = College.objects.all()
    data = json_serializer.serialize(queryset)
    return HttpResponse(data, mimetype="application/javascript")

