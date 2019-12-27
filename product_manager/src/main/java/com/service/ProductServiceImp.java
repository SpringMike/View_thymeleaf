package com.service;

import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Rau muong", "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxASEBUQEhIWFRUWGBUXFRgVFxUYFRgXFxUWFhUWFRgYHSggGBolGxcWITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGi0fIB8tKy0tLS0tLS0tLS0rKy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIALcBEwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAAAQQFBgcDAgj/xAA+EAABAgMEBwYEBQQCAgMAAAABAAIDBBEFEiExBkFRYXGBoQcTIpGxwTJC0fAjUmJy4RQkkqLC8TNjU4Ky/8QAGgEAAgMBAQAAAAAAAAAAAAAAAAECBAUDBv/EACURAAICAgICAQQDAAAAAAAAAAABAhEDIQQSMUFREyJhcSMyM//aAAwDAQACEQMRAD8A0RKhC1jNBCVCBAEISoARCVCABCEJACClVP7QbcMKGJeGaRIuZ1tZr4E5cKrnkyKEbZPHjc5UiI0v0tdEcZeWNG4tc8ZuOtrTs38VT4rGtABx50b/ADxK6uAY2usjDcE3hyz340wWTPI5u2bEMagqR6bFAxawBdGRYjgaPIG0GlOB2LqyTY3F+J35cgm0/HcRdAoNmAXO0T6sbx7n/wAhcTgcD7LpLWTFiOvNJA3g3eajGlwNMvVWazZ5xg3AaA1y10zO9dFs5vQSWj0ZkSoexgrWpddFNfHD0VhsbSF8B90x3RoYwIINa1OLXO9FASMxea6E8m640BO3Gh6FNIEJ8GI+G8ZCo3jbvGKIycXoJQUvJrNn6Sy8UgXi0nU8U8jkpgFYnIRi55aDTccFe9G7Tisox5Lmawc27wdis4+buplbJwtXAuSKIBSrQTsznoRCVCYCISpEACRKhACISpEACRKhMBEJUIA8oQlQAIQhAAlQhAAhCVIBEqEIA5TMZrGOe40a0Ek7hiVik/POmpl8Z3zOw3NGQHJX3tMtMw5YQWmjoppvujPrQLOZcBoA3f8AQWZy8ly6/Bp8PHUe3yScKWvmp+EdT7BO4sMgZ0aPugC5WZEL3BrclMuki9wbs+6qlJ60X4x+SFl7PfFdRowTyespkFuV5xw3k7FcJSQbCZliomDAMaIYmN3EM/aM3cz/AMVWbZZUVRVYejt4FzhXUPdcZaVdDeQcrp6gEdFos1JgMugUo2mG13hH3vVUtmXo4uGx3TALrCTRznCLIJzCGwiR89DzN4dbymoEIRoIPzsJaNpAzCaz0L8Lh4hyP0culiRCIjhqJBHMVXTucuhHNl7sQ1wINMdf0/lW+zJigF6ork7+dfA4qL0kkagxGjMY7a4ffNeNGp12LHFrq5tJHUHWpUpEW3A0azJgObd2J8qhLkw33mGhBxab1CNxp90Vnk5xkQeE4jMaxy2b1o8XJrozM5eNX3j7HCEqFcKQiEIQAiEqEwEQhCAEQlSUQAIRRCAEQhCYAlSJUACEISAVCEIAEtEJtaMyIUJ8Q/K1x8hgoydKxpW6Mm09nu/nyAathi43l8X+xKr74lT98Au0dxLnOOZrXnmutgSDo0VtBgCD5LDyS7Ns3oR6xSRZNHmw2MBc4B3orFo6O8e47PrReoNkSpaW5O10OvD6qGlXvk5mlSWOyO6utcjsi2WyzwXRhe8I5mnpVdLOkboApsA4D+aeSZz82HPgu1F3W66nVWKC4BoNNR9U1FMHJpEbOsGW0k8mijfZVO2JfwcfdyuMYtoScKAdcfZQlryoLMP0eoPuEpIcWVksvQeXqKeoC4SULBrtdB6VT+DCNxzdxp/kuMCFRjfvLBKI5ImozA+Fy9Aq2AYbw66DjjgCrDZkbw0Or0rRRNrsuuJGVdWzPDqpRdMjJWiyWfMEsvNoKZgAA8BgAPNQekNtRmuY1l6+6oFw0e0DMEg8KrpZdoNYwknAAkY578dSpsSajTM2XQ773jBrWDHXU7gBU03KzdrRUpLyWSR00mJd7mxmviMJqC6ppiderCitdgaZS8ybmMN+wkEHgfqsmm5e0YbSIzIrWOGbq3TSmZyFaa0xs+bLYgNaEFSWfJjIPBiyH0YhQujFomLBaScaemrippaOHKskbRm5sLxS6sRCVC6nIRCEIARCEJgCEIQB5QhKEwBCEJACVCEACVIlQAKB00mAyUfXX7Y+tFPLPO0y1AC2C01OZHoq/Jn1xsscaHbIijiC55DG4veaADMkmgC1aw9Gmy0vdFDEp4nb9YG5U/s6kL82YhyhNqP3ONK+VVrLW4LI8mykZ1bUtClpZz7l+M91A55d4czUUI2UCXRSMJhpgRSIty6WvFaEEZVIBqDhyWgRZFjxRzQ4HMEAhcIFkwIP/jYG4k0aAASdabVqmJOpWhlFsIRIVxpoRQtOwjIptDnY0Id3FhkOGRAqx3MZc1apKHRtVwm2jWFHpS0SU7dFQdbMJxIJoTqPNLpFVkuXA43Q7yd9Ank5ZkrGdQ0D9RFKpha9kx2QnNrfZQtw2Y4HYVHdE/ZFS0y18G9rof8A9UQaXW7iVXpGbLYboZzF4ebm0906ZOHu6/qIHmUJ7G/BJysQh3Mj78kxtabbUsJzxbxSy0yMeJ9CoC0Y9TSp2H9wzz2gppbOblobT8+67cGePGuSs3ZZD/uKnMteR09vVUt4eczi7I7le+ztv92G6mw3dboVjF/dFbL/AEZf7YkGxoMSE4VDmkc9R5FfP0WCWvpsNPovouZfda52wE9Fg03CvPcdpB9135lWivwrpl/0Mmvw2U2DzzH/ACCvjHgio1rKtE4xax2OQa7ywd7LR7KmAat4OHPNceJk6ZK+SzzMffH29okEIQtcxQSJUIARCEIASiEqEwPCVCEwBKkSpACAhCAFQhCQDC27TZLQXRXnL4Rrc7U0LEJ+edGjOivNXE8hsAVx06jxpmcMnD+GG1peTk29THjiByKozGgZY5037ysnlZXKVeka3FxKMb9s1Dsylx3UV41vA/xYPclX+GxU7szYBIsP5nPP+1K9FdWrgi3YE0XGE2+6i5zESpuhPpWHcbvKa2yMtHt2wJpassXw7rTTaRnTZXUnLDiu5GCn5IX1aMr00Y2AIIY18Ml1YkXxPc2hHw40Os76J3oPbMV7RBj5G9ccfnpQGtdYqAr5NSjXAtcAQdRUU/R+HVhb4bh8IGQ2gDYoSWicau7KHpxYghRBFhjBx8Q1Z19lAwjVrBqq53IYDqVq+kVld7CprGKzBkIQXRA/Duz0BJ+i4SVaO6d7OQdR5r8ufFVubjl7ydV4kKbfCeWb3eI7ccU1j2PGDO97p1zW4jAfwukKRyyW3oZy5qd33itG7MpE0iTJBo6jGE6wMXEbq0HJUmx7IfMRWwWa8XHUxus8VtNnybIMJkJgo1gACu8bHcr+ChycnWPX2xhpXMXJSKdZaWji7wj1WSPYDXkFpHaBHIgBg+Zza+vss8Dc+ajypXOvgnw41C/kkdHG404g8CCPUBXGwo1Hs5t5EVCptj4PGOZ+h+qnZOZuxaHUfev181UupJl2u0Gi/hCRhqAV6W8meearQiEFCYgSJUIARCEIA8oQhMBUIQgASoQgACVCEgM+0jPcR5wnAxYcN7Dto0wyORJKzaZiXRRaj2qw2CBCikeIOLa/pIqR5gLH4sWpJ8ljchNZGjZ48v40zcezg1kIO4OH+7lau+oaVVE7I5qsncObIjxyNHD1KsukLcGxGuLXB2BGzWCMjVcW6LcI9mkOZuC++IjK1ByrgU4fazmtqYT3DXdAJG+lceSYwbQfDa18QB0N2T26v3DVxUvKTEKIKscHDchL4HODStqzoyKDQjinTHriGADAUSscui0cHTOxXgoLlziPUmxJHOaOCzjTay70RpYMX1DgNYGPqrzOzKizJuiPDy0mmR1DbXiq83ssQjogtG5JnhvsNTSpI17PXHgpe3oHdwXgVLXNcxrc7zzg2nMqUdBaLoAoMTjStRq4a/NcGQi6LV+NB4Acm/mPHEclLFgeR0QzchY42MdEdH2ykEA0MR1DEI27BuCsCUBeIrqA9PZbcYqCpGDOTnK2UjT2LV0Ju0vdyAuj3VOhj740+qndLZm/PFgyhta0csXdaqCgmrK7PdqysrubNfDGsaHMk6hrwP1T2ejER6g0vNa4ent1UfCdTHf01dCnVpi93bhqFDwqKnkCuEyxA1KQiXoTHbWg+YThRujUS9KQSc7gB4io9lJLcxu4IwMiqbX5BIhKpkBEIQmIEIQgDwhCVMAQhCAFQhKkAIQhAFC7XT/as/d7LG4ZqegW09rEKsqw6r9082lYzDbQndgsnk/6M1uN/mjQOyOeuTESCfnaHD9zcCByPRapMyvew7q+f9HbWEtNwYpNGhwDj+l3hcTwBryX0bIEFoVdxLkJ9dr0QEvFjS9GZsBrdPw8jmE5iTIfUiEGuwo5rgCPIY61PPl2nUkbLtbkAimtHeXIhPbjsi4ExNV8TGuZ+atHc2kUPmpJpOa9kryXJnBtP0IYhXGPFwXuJEAFSVGRpi/lltUZSCMbG0WK50RoaKitXcFNti4UomVnNaWXmkGtcRjlhTknau4uInFORRzcxqbjH0eLtTU8ty8geM7vXBdUAK7DHGCpFCeSU3cmCZ2nNCGwvPyivll1Twqi6c2sDEEqDsLuGodSo5snSFk8GPvOioPj35hzicxVeJY/hg8OhXmHQx30ywaOqWUb+GW7KjqVkezYXg9Q4niunWPSoKdRH1hMdrBFeor0ULMRaPafvGilLJhmMRDbmX3fOn1qoS2Si6NU0bh3ZOAP/W0/5eL3UmvMNgaA0ZAADgBQL0t6CqKRgTdybEKEIUiIJEqRMQIQhAzwlSJUxAhCVAAlSLw2KC4tGJGYGriotpeRpN+Dohe7lMT0UJb2kMKXYSKF2wYlcZZ4o7RwSkRXaO9hl2QifE514DXRoONOax+0pO6cMb2I8lJWja0SPMuiOcSXENFTkCaAclzjxmuiubsNBywCzMuTvOzUxY+kKK8JF0WIGCjQPic6t1oJxJ+ma2Ts90rZcEpEeXGGA1sRwoHgYDgeKz6WlAb9MrxPRSujctQuO0gJZMia0ieODTs2+HNNIzREmmjMqoWVKuuNo4+ak2SJOdVy7M69USMW0mDWmcS0ifhFV0hyLdicslQNSWxpxI5kJ78XnDYvNqRe6gvcBi1jnAbwCQpZ7QAoG2XFwLRlTH6KL0TW/BXezW0zffAccHYiv5syRxB6LQ1kFnNMCbeW4UdeG7L6LV5GabFhiI3XmNh1hb2JfxRl8mJyoVMcIQhTKpxmo7YbHRHGjWNLjwAqVgkzaj40Z8U1Je5x4AmgG5a12lTBZZkambrjeTniqx+Uly2He2hpPN38LO5krkomjw40myQswULuI9T9E9hil8bz9fZNbPGraT0XZj8Sdo/j6+apl4iZr4gN/orv2ZSd+IYhGDSXc6UHr0VRfKEu4Bah2dSgZKl2tzvQV910wx7ZUjlnl1xSZakIQtpGICRKkQAJClSIAEIQmI8JUiVMAQhKgCPt2f7iA6JryGFcSmkbSiTl4I7twfXGrSMScSTU1qo3tAn3BjJWEL0SKCaflblUqlw9FYwoY1WtPzAEgfupkszPlk5VE0uPiioXIlbW0/ixKtZ4W7sTTZs9VBRpp0QEnnXJSc9ISMpCvlzYjjkMHY7xl5qFgR3RaudhXANGQGpVnfstxr0iAm3lrwRqII30NVzn3Ufeb8xLh98FLzdnkeI+X3moiN4aB2s4DMjbVRjFtkmSFhzBMW6fmFef3VXOxJSjA7a8eVaKpWPLVmId1pNGkkDM1JAWof0JZBBpSlw86iqhJbonD5JaxW0bTYppoUZ3NxweMnZ8U/hxU46CW2OGBK5eWvXlzk2xJHOZdgoWdLWtLnEACpJOQAzUvGKzXS23O+f3UM/hNOJHzuGz9I6lPFx5Z59UdHkUFZHxZoPjOe3AOy20GRKuOg8/SOILvhiYf/alWnjq5qgtdRWXROrpuAB+dp8sT0C9J9KMcPReEjOm+ztmozMo5mOY2/VN1PjEKMnZS74m5a938LOx5b0ypkxVtFZ0xs/v5GNDAqbhc39zfEPRY3KvvMaz9N3yJI6Hot+Kym3bB/p5uI1o8EQd5D2b28jVV+bDxJFnhTW4sgJZpYWg6v4TmAAC8bD0quroQLa7CB0w6eijo0ejyK/Fd91SXgvslZN7HB52Zei0bRBw7gganE+YH0WUQIb2FrDg40rzFP5V40atIw3A/K4APGw4UPXopYsnTIpMjmx/UxuK8l7QV5Y8EAg1BXpbSaatGE006YIQkUhAhCEAIhCExHhKkSpgCVIlQBXJaW7y14l4YNhwwK7CAfVXCZl2hpNNWKr8tBItQOHzwW14tJH0VjtdhMF7RmWOA4lpCzPn9s0/S/R84WzaH9RMvihoALiGAAABoNAf5UpZNnHu++iG6zIU+J52N+qibOlQ6NBhPwBiNY/bS+AVrUhZojTVLoEGB4GNGVRhXzHkN6rxj2dliUuqozrTNkSDCg1F0xQ5wbQVDAQG13mpVVkJJ73VArTE7AN5V87XR3lothDKHCZ/sST7KtwZ8MaIUMYEgE9FciuqUYLbOf8AbbLx2f2KLpjHEuNOAGpXecgVhFoVP7MJu9BisriyK7yIH8q/QADgVSyY+k2mWlK1Z1hwqwxXYm4h0Ug3BibwBXFJoin5OZC84py9oVJ020juAy0E+Mij3D5AdQ/UR5JwxSyS6xJdklbGOmek169LQHYZRHjXtY33PJU9o1JGtGpKvQcfBHFGkVJzcnbPVFb+zSHenWnUxr3dKe6qAWp9mFlGHAdMOGMU0b+xpOPM18gnyZ9cb/JAvDCvZoQuIK9XljgRU1BuOI1auCrulsqHQO8+aHiDuOB9vJXGch324ZjL3Cr1sQw6BFafyOr5Fd21PG0yurx5E0ZbAbeFNtW+7T51HNQswy9EAOBBwPA1x25lWR0o6FLQY+feAmu8ONOnuoC1yL4iNyIDhxxqPULLprRr9k1ZITYdFZDiFtHw6Q4lNrfhNN4xqpCWjBpDjkcHU1beWPVN7FiiJQtoSRRzTk9uHUfeSeTkr3YvN8TAReGsDY8bN653emdK9otVjRngAsIIOTScHfsdt3HFT8GOHYZOGbTgf+t6pGi8ekWJLnxMoIja62mmIOpwDga8VdO4qBXEt+F3zcz67VqcRProyOY05bQ4SIQrxRBCEiABCEJiPASpEqYAhCVJgcWD+/gD/wBUU8hd+qscVlRRQdz+9hu/LCd/s4D/AIqwBZvtmkvCMD03sN0CaiXRgXd6w7KmpHI1V+7PZ0Rob3HB16rhvcPrVeu0uFdEKOB8LqHeDgR5VUXo5/aT3dOwZFHh2Z4eR9VwX2zLLXaH5IrTfRWajT8VzS2sVt5mJwYwNZQmmdcVWIuhFoQyH9wXNFDVhBw4Zrc7Xl8WxhmyoO9rsx6J/AYCwYalcx5HB2V2z580HtYys3EDwQx7i14INQa4Gm5bPKxQQHA1BxBGSp3apYDWXZyG0D5ItBmfkeeorwULobpSYThAin8M/C4/Id/6VLPg+rH6kfJ1x5K0zV4r6toucM0FFU7Q08k4Yo1xiu2My/yOHqqfaum83GqGHumnABnxHi7PyoquPi5Mnqv2dXkjEvelmkgl2XIZBjOwaMDd/U4egWYkkkkmpJJJOJJOJJ3ryxp1klxxJOZKVbHG4ywr5ZwnNyFQkSivPUrJAlNG7IdNTDYIyzeRqaMz7cStxl4LWNDGijWgBo2ACgCr2gWj/wDSwLzx+LEo5+0D5WcvUqyxDqWVycveVLwhHklKvMJqV7wFXAR+1VTS+fBhd1D/APNG/DaOOBedwFfJerc0naHdzC8b60NMQDs3ncutkWE8OMzHN6KRRo/I06hvUe1ukScdWxtP2O10n/TDG4wBh/U0YH72rHp0G4RTFp/7+9y3SYiBjXOdgGgk8gSsY0hl3QYxY752h/8AmA7pkjlwSpoOHNu0yHsyf7qJd1HEe9NhCu8va4cBePip4X4Go2O/MFm0Z9Bezuu90+hzTmEgYtzLeIBvt2aqqlKN7L0J1o1bRSXBjmIBQBhbTMVJb8B2UVvWUaGWy9sQCpMOovA6uG+lVq4Wnwn9lGVzV/JYqRKkKuFMEISIAEIQmI8JUITAErM0qFCfhko+UdZdv4l4/FUA8BWnqVNgoQqDNAqemMMTDoUm3NzrzzsYBieKZaaSI7uHFbg6HEh0O5zg0jqPJKhc6tM6J00i1VvMaTrAPmE5gtoKJEKfoh7GlrWfDmIT4MQeF4LTtGwjeDQ8l8+2pIvgRosF9Kw3Fhpkccxy9UIVziP7qERogEmg1rSdE+zN7w2NNvuNzaxhBca/mdiG8kIUuRklDSEhzbfZ1EZV0u++PyvIDuTsjzoqRHguY4scKOBoRgfRCF042WUtMaOdFduzbR8RopmogBZCPhG1+dSNgz4oQunJk449DNVK5RHUw1lCFlIQrMcBkMyoDTGZeyG2HDJDohu1GBprodWdK70ISkSj5PejOjEOX/FeA6MRn8rAflYNXHMqwPahCSVBJ2VrSOHUNhaojgD+1tXvHMNpzWWdpcyHTLLuqGBXbifJCEZXcQxJKaKP8rt9PP7ou5+FjhmAehI9CEIVRlouug0l30x4ABDa1neUwvOa4nI4/EacAtYSoWnxUulmZy399CIQhWiqCQpUIARCEJgf/9k="));
        products.put(2, new Product(2, "Rau ngot", "data:image/jpeg;base64,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"));
        products.put(3, new Product(3, "Rau cai", "data:image/jpeg;base64,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"));
        products.put(4, new Product(4, "Rau ren", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTmywCIx9bKKJXINf56jgoO3vYVRekUGPHAWg0B82UDgPKNrFwn"));
        products.put(5, new Product(5, "Rau mong toi", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTX9qTEXABWlAIhoexKiSvpQBQX6ZyLF62UED70E9qvioltCYDu"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String findName) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().contains(findName))
                foundProducts.add(product);
        }
        return foundProducts;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}