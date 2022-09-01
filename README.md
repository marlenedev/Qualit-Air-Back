# g2-meteo-back

| ID   |      SERVICE      |  FAIT |
|:----------:|-------------|:------:|
| S001 | GET /themes|  | => thème
| S002 | GET /discussions|  | => fil d'actualité
| S003 | GET /posts|  | => détail discussion
| S004 | POST /utilisateurs | | => inscription
| S005 | GET /utilisateurs/{id}|  | => authentification
| S006 | GET / utilisateurs/{id}/historique?indicateurs={indicateurs}&commune={commune}&dates={dates}  |    |
| S007 | POST / utilisateurs/{id}/historique?indicateurs={indicateurs}&commune={commune}&dates={dates} | |
| S008 | GET / utilisateurs/{id}/indicateurs?commune={commune}|  |
| S009 | GET /utilisateurs/{id}/favoris  |    |
| S010 | POST /utilisateurs/{id}/favoris | |
| S011 | DELETE /utilisateurs/{id}/favoris/{id}| |
| S012 | POST /utilisateurs/{id}/themes/{id}/discussions/{id}/post|  |
| S013 | PUT / utilisateurs/{id}/themes/{id}/discussions/{id}/like/{id}  |    |
| S014 | POST / utilisateurs/{id}/themes/{id}/discussions/{id} | |
| S015 | PATCH / utilisateurs/{id} |
| S016 | DELETE / themes/{id} | |
| S017 | POST / themes | |
| S018 | DELETE / themes/{id}/post/{id} | |
| S019 | PATCH / themes/{id}/post/{id} | |
| S020 | POST / themes/{id}/post/{id}| |
| S021 | GET / utilisateurs | |
| S022 | DELETE / utilisateur/{id} | |
| S023 | PATCH / utilisateur/{id} | |
| S024 | POST / alert | |

