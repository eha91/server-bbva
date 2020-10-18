from rest_framework import serializers

from backend.models import Emoji


class EmojiSerializer(serializers.ModelSerializer):
    class Meta:
        model = Emoji
        fields = ('__all__')