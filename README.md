# g2-meteo-back

| ID   |      SERVICE      |  FAIT |
|:----------:|-------------|:------:|
| S001 | GET /themes|  | => thème
| S002 | GET /discussions|  | => fil d'actualité
| S003 | GET /messages|  | => détail discussion
| S004 | POST /utilisateurs | | => inscription
| S005 | GET /utilisateurs/{id}|  | => authentification
| S006 | GET /communes/{id}/historique-indicateurs?indicateurs={}&dateDebut={}&dateFin={}  |    |
| S007 | POST /communes/{id}/historique-indicateurs?indicateurs={}&dateDebut={}&dateFin={} | |
| S008 | GET /indicateurs?commune={commune}|  |
| S009 | GET /utilisateurs/{id}/favoris  |    |
| S010 | POST /utilisateurs/{id}/favoris | |
| S011 | DELETE /utilisateurs/{id}/favoris/{id}| |
| S012 | POST /themes/{id}/discussions/{id}/messages/{id}|  |
| S013 | PUT /themes/{id}/discussions/{id}/messages/{id}/reactions/{id}  |    |
| S014 | POST /themes/{id}/discussions/{id}/messages/{id}/reactions/{id}  |    |
| S015 | POST /themes/{id}/discussions/{id} | |
| S016 | PATCH / utilisateurs/{id} |
| S017 | DELETE / themes/{id} | |
| S018 | POST / themes | |
| S019 | DELETE / themes/{id}/messages/{id} | |
| S020 | PATCH / themes/{id}/messages/{id} | |
| S021 | POST / themes/{id}/messsages/{id}| |
| S022 | GET / utilisateurs | |
| S023 | DELETE / utilisateurs/{id} | |
| S024 | PATCH / utilisateurs/{id} | |
| S025 | POST / alertes | |
| S026 | POST / connexion | |
| S027 | POST / deconnexion | |

