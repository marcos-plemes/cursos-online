import {Spacecraft, Containership} from './base-ships'
import {MillenniunmFalcon} from './starfighters'

import * as _ from 'lodash'
console.log(_.pad("Typescript Examples", 40, "="))

let ship = new Spacecraft('hyperdrive')
ship.jumpIntoHyperspace()



let falcon = new MillenniunmFalcon();
falcon.jumpIntoHyperspace();

let goodForTheJob = (ship: Containership) => ship.cargoContainers > 2;
console.log(`Is falcon good for the job? ${goodForTheJob (falcon) ? 'yes' : 'no'}`)