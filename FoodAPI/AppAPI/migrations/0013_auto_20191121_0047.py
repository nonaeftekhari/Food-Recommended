# Generated by Django 2.2.7 on 2019-11-21 05:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('AppAPI', '0012_auto_20191121_0032'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='userEmail',
            field=models.EmailField(default=' ', max_length=50, primary_key=True, serialize=False),
        ),
    ]
