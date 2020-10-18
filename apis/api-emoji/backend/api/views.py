from rest_framework import viewsets

from backend.models import Emoji
from .serializers import EmojiSerializer


class EmojiViewSet(viewsets.ModelViewSet):
    queryset = Emoji.objects.all().order_by('?')
    serializer_class = EmojiSerializer