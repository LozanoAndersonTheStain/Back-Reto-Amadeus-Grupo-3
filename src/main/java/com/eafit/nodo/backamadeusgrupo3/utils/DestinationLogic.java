package com.eafit.nodo.backamadeusgrupo3.utils;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationResponse;

public class DestinationLogic {
    public DestinationResponse determineDestination(String destino, String climatica, String actividad, String alojamiento, String viaje, String edad) {
        String destinationA = "";
        String destinationB = "";

        boolean b1 = "30-50 años".equals(edad) && "Hotel de Lujo".equals(alojamiento) && "Deportes y Aventuras".equals(actividad);
        switch (destino) {
            case "Playa":
                if ("Caluroso".equals(climatica)) {
                    switch (viaje) {
                        case "1-2 semanas":
                            if ("Menos de 30 años".equals(edad) && "Deportes y Aventuras".equals(actividad) && "Hostal o Albergue".equals(alojamiento)) {
                                destinationA = "Tulum";
                                destinationB = "Ibiza";
                            } else if ("Menos de 30 años".equals(edad) && "Relax y Bienestar".equals(actividad) && "Hotel de Lujo".equals(alojamiento)) {
                                destinationA = "Playa del Carmen";
                                destinationB = "Santorini";
                            } else if ("30-50 años".equals(edad) && "Cultura y Museos".equals(actividad) && "Hotel de Lujo".equals(alojamiento)) {
                                destinationA = "Honolulu";
                                destinationB = "Malta";
                            }
                            break;
                        case "Menos de una semana":
                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(actividad) && "Airbnb".equals(alojamiento)) {
                                destinationA = "Cartagena";
                                destinationB = "Barcelona";
                            }
                            break;
                    }
                } else if ("Templado".equals(climatica)) {
                    switch (viaje) {
                        case "1-2 semanas":
                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(actividad) && "Hostal o Albergue".equals(alojamiento)) {
                                destinationA = "San Juan";
                                destinationB = "Niza";
                            } else if (b1) {
                                destinationA = "Río de Janeiro";
                                destinationB = "Lisboa";
                            }
                            break;
                        case "Más de dos semanas":
                            if ("Más de 50 años".equals(edad) && "Relax y Bienestar".equals(actividad) && "Airbnb".equals(alojamiento)) {
                                destinationA = "Punta Cana";
                                destinationB = "Algarve";
                            }
                            break;
                    }
                }
                break;
            case "Montaña":
                if ("Frío".equals(climatica) && "1-2 semanas".equals(viaje)) {
                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(alojamiento)) {
                        if ("Cultura y Museos".equals(actividad)) {
                            destinationA = "Ushuaia";
                            destinationB = "Reykjavik";
                        } else if ("Relax y Bienestar".equals(actividad)) {
                            destinationA = "Aspen";
                            destinationB = "Innsbruck";
                        }
                    } else if ("Menos de 30 años".equals(edad) && "Hostal o Albergue".equals(alojamiento) && "Deportes y Aventuras".equals(actividad)) {
                        destinationA = "Bariloche";
                        destinationB = "Interlaken";
                    } else if (b1) {
                        destinationA = "Banff";
                        destinationB = "Zermatt";
                    }
                } else if ("Templado".equals(climatica) && "1-2 semanas".equals(viaje)) {
                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(alojamiento) && "Cultura y Museos".equals(actividad)) {
                        destinationA = "Cusco";
                        destinationB = "Granada";
                    }
                } else if ("Menos de 30 años".equals(edad) && "Airbnb".equals(alojamiento) && "Deportes y Aventuras".equals(actividad) && "Más de dos semanas".equals(viaje)) {
                    destinationA = "Machu Picchu";
                    destinationB = "Chamonix";
                }
                break;
            case "Ciudad":
                if ("Caluroso".equals(climatica) && "1-2 semanas".equals(viaje) && "Más de 50 años".equals(edad) && "Hotel de Lujo".equals(alojamiento) && "Cultura y Museos".equals(actividad)) {
                    destinationA = "Los Angeles";
                    destinationB = "Roma";
                } else if ("Frío".equals(climatica) && "1-2 semanas".equals(viaje) && "30-50 años".equals(edad) && "Hotel de Lujo".equals(alojamiento) && "Cultura y Museos".equals(actividad)) {
                    destinationA = "Toronto";
                    destinationB = "Berlín";
                } else if ("Templado".equals(climatica) && "1-2 semanas".equals(viaje) && "Cultura y Museos".equals(actividad)) {
                    if ("30-50 años".equals(edad) && "Hostal o Albergue".equals(alojamiento)) {
                        destinationA = "Ciudad de México";
                        destinationB = "Madrid";
                    } else if ("Más de 50 años".equals(edad) && "Hotel de Lujo".equals(alojamiento)) {
                        destinationA = "Nueva York";
                        destinationB = "París";
                    }
                } else if ("Templado".equals(climatica) && "Menos de una semana".equals(viaje)) {
                    if ("Menos de 30 años".equals(edad) && "Airbnb".equals(alojamiento) && "Relax y Bienestar".equals(actividad)) {
                        destinationA = "Miami";
                        destinationB = "Viena";
                    } else if ("Más de 50 años".equals(edad) && "Hotel de Lujo".equals(alojamiento) && "Deportes y Aventuras".equals(actividad)) {
                        destinationA = "Chicago";
                        destinationB = "Londres";
                    }
                }
                break;
        }
        if (destinationA.isEmpty()) {
            destinationA = "Bora Bora";
            destinationB = "Dubái";
        }
        return new DestinationResponse(destinationA, destinationB);
    }
}