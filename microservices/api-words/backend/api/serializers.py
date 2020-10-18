from rest_framework import serializers

from backend.models import RandomWords


class RandomWordsSerializer(serializers.ModelSerializer):
    class Meta:
        model = RandomWords
        fields = ('__all__')