export class customer {
    constructor(
        public name: string,
        public phone: string,
        public email: string,
        public gender: number,
        public from_loc: string,
        public to_loc: string,
        public from_pick: string,
        public to_pick: string
    ) { }
}

export class customer_info {
    constructor(
        public name: string,
        public phone: string,
        public email: string,
    ) { }
}