from django.http import HttpResponse
from django.core import serializers

from sim.models import College

def sim_home(request):
    json_serializer = serializers.get_serializer("json")()
    queryset = College.objects.all()
    data = json_serializer.serialize(queryset)
    return HttpResponse(data, mimetype="application/javascript")

def createCollege(request):
    if request.method == 'POST':
        newCollege = College()
        newCollege.name = request.POST.get('name', '')
        newCollege.short_name = request.POST.get('shortName', '')
        newCollege.address1 = request.POST.get('address1', '')
        newCollege.address2 = request.POST.get('address2', '')
        newCollege.city = request.POST.get('city', '')
        newCollege.state = request.POST.get('state', '')
        newCollege.country = request.POST.get('country', '')
        newCollege.email = request.POST.get('email', '')
        newCollege.phone1 = request.POST.get('phone1', '')
        newCollege.phone2 = request.POST.get('phone2', '')
        newCollege.save()
