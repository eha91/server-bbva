from rest_framework.routers import DefaultRouter
from django.urls import path

from .api.views import EmojiViewSet

route = DefaultRouter()
route.register('emoji', EmojiViewSet)


urlpatterns = []
urlpatterns += route.urls
