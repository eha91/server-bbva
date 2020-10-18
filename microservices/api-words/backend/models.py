from django.db import models


class RandomWords(models.Model):
    phrase = models.CharField(max_length=80)
