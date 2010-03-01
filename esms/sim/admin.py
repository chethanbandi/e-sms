from django.contrib import admin
from sim.models import College

class CollegeAdmin(admin.ModelAdmin):
	fields = ['name', 'short_name', 'address1', 'address2', 'city', 'state', 'country', 'email', 'phone1', 'phone2']

admin.site.register(College, CollegeAdmin)
