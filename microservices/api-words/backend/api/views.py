from rest_framework import viewsets

from backend.models import RandomWords
from .serializers import RandomWordsSerializer


class RandomWordsViewSet(viewsets.ModelViewSet):
    queryset = RandomWords.objects.all().order_by('?')
    serializer_class = RandomWordsSerializer