from django.db import models


class Emoji(models.Model):
    image = models.CharField(max_length=255)
    name = models.CharField(max_length=40)

# Create your models here.
