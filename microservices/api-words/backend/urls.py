from rest_framework.routers import DefaultRouter
from django.urls import path

from .api.views import RandomWordsViewSet

route = DefaultRouter()
route.register('phrase', RandomWordsViewSet)


urlpatterns = []
urlpatterns += route.urls
