# g2-meteo-back

| ID   |      SERVICE      |  FAIT |
|:----------:|-------------|:------:|
| S001 | GET /themes|  | => thème
| S001 | GET /discussions|  | => fil d'actualité
| S001 | GET /posts|  | => détail discussion
| S004 | POST /utilisateurs | | => inscription
| S005 | GET /utilisateurs/{id}|  | => authentification
| S006 | GET / utilisateur/{id}/historique?indicateurs={indicateurs}&commune={commune}&dates={dates}  |    |
| S007 | POST / utilisateur/{id}/historique?indicateurs={indicateurs}&commune={commune}&dates={dates} | |
| S009 | GET / utilisateur/{id}/indicateurs?commune={commune}|  |
| S010 | GET /utilisateurs/{id}/favoris  |    |
| S011 | POST /utilisateurs/{id}/favoris | |
| S011 | DELETE /utilisateurs/{id}/favoris/{id}| |
| S013 | POST /utilisateurs/{id}/themes/{id}/discussions/{id}/post|  |
| S014 | PUT / utilisateurs/{id}/themes/{id}/discussions/{id}/like/{id}  |    |
| S015 | POST / utilisateurs/{id}/themes/{id}/discussions/{id} | |
| S016 | PATCH / utilisateurs/{id} |
| S018 | DELETE / themes/{id} | |
| S018 | POST / themes | |
| S019 | DELETE / themes/{id}/post/{id} | |
| S019 | PATCH / themes/{id}/post/{id} | |
| S021 | POST / themes/{id}/post/{id}| |
| S022 | GET / utilisateurs | |
| S023 | DELETE / utilisateur/{id} | |
| S024 | PATCH / utilisateur/{id} | |
| S025 | POST / alert | |
| S026 | POST / deconnexion | |
