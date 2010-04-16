from django.conf.urls.defaults import *
from esms.settings import DEBUG, PROJECT_DIR

from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Example:
    # (r'^esms/', include('esms.foo.urls')),

    # Uncomment the admin/doc line below and add 'django.contrib.admindocs' 
    # to INSTALLED_APPS to enable admin documentation:
    # (r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    (r'^$', 'esms.views.sms_home'),
    (r'^sim/', 'esms.sim.views.sim_home'),
    (r'^sim_form/', 'esms.sim.views.createCollege'),
    (r'^admin/', include(admin.site.urls)),
)

if DEBUG:
    urlpatterns += patterns('',
            (r'^site_media/(?P<path>.*)$', 'django.views.static.serve', {'document_root': '%s/www/site_media' % PROJECT_DIR, 'show_indexes': True}),
    )

