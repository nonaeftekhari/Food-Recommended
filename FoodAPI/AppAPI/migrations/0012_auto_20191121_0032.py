# Generated by Django 2.2.7 on 2019-11-21 05:32

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('AppAPI', '0011_remove_rest_restrating'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='rest',
            name='restPrice',
        ),
        migrations.AlterField(
            model_name='rest',
            name='website',
            field=models.URLField(default=' ', max_length=50),
        ),
    ]